# Criteria JPA

- **CriteriaQuery** é uma interface do JPA isso significa que não podemos dar new para instanciar.
	Quem fornece a implementação é o **EntityManager** que possui o metodo *`getCriteriaBuilder()`* que vai dar a implementação da Criteria atraves do *`createQuery()`*
    
    ```java
    CriteriaQuery query = em.getCriteriaBuilder.createQuery();
    ```
    
 O *`CriteriaBuider`* especifico alem de criar o `criteriaQuery` ele também cria varios outros metodos auxiliares para sua query, como por exemplo: Soma, média, max, min, como é importante é melhor criar uma vamriavel só para ele.
 
  ```
  	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery query = criteriaBuilder.createQuery();
  ```
  
  Uma coisa importante Criteria que ela **é fortemente tipada** seguinifica que qualquer método chamar vai retornar um tipo especificado ou lista do tipo especificado, é passado atraves dos **genéricos**
  
  ```java
  	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
  ```
  
  Com fazemos para buscar um lista no *sql:* `Select * from`e aqui fazemos a mesma coisa, aqui chamamos o método `from`do *criteriaQuery* passando a entidade que vamos buscar.
  
  ``` java
      query.from(Produto.class);
  ```
  
  O **Criteria JPA** é apenas um recurso para facilitar a escrita das buscas, e no final das contas no final vamos precisar fazeer é transformar essa *criteria* em *TypeQuery* comum.
  
  ```java
  	TypeQuery<Produto> typeQuery = em.createQuery(query);
    return typeQuery.getResultList();
  ```
  
  Tudo isso já e´suficente para realizar uma busca no banco:
  
  ```java 
  public List<Produto> getProdutos() {
  	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
  	CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
    query.from(Produto.class);
    
    TypeQuery<Produto> typeQuery = em.createQuery(query);
  	return typeQuery.getResultList();
  }
  ```
  
  > O mais importante o usu da Criteria é poder **filtrar** os resultados das buscas.
  
  Para fazer esses filtros vamos precisar pegar as referencias dos atributos das classes 	no exemplo: **Produto** para fazer as comparações. Para pegar essas referência, a JPA fornece uma instancia da *interface* `Root`atraves do metodo `from`:
  
  ```java
  	Root<Produto> root = query.from(Produto.class);
  ```
  A partir dessa `Root`que agente consegue traçar os caminhos pára cada um dos atributos:
  
  > *Exemplo:* traçar um caminho para o atributo *nome* de produto:
  ```java
  	root.get("nome");
  ```
  > esse caminha a JPA chama de **Path**
  
 ```java
 	Path<String> path = root.get("nome");
 ```
 > Como o atributo *nome* é tipado como `String` o *Path* tambem tem ser tipado com o mesmo tipo, e o metodo `get()` também recebe um generico de metodo com o mesmo tipo do Path.

 ```java
 	Path<String> path = root.<String>get("nome");
 ```
 
 Agora precisamos dizer que o atributpo representado por esse caminho tem ser igual ao parametro passado no método, e quem promove isso é *criteriaBuider()*.
 
  ```java
 	criteriaBuider.like(path, nome);
    ou
    criteriaBuider.equal(path, nome);
 ```
 > Filtro é o mesmo que predicates
 
 ```java
 	Predicate predicate =  criteriaBuider.like(path, nome);
 ```
 
 Agora montamos a query com criteriaQuery()
 
 ```java
 	query.where(predicate);
 ```
 
 Pode repetir para os demais atributos. O código final com mais atributos ficaria assim:
 
 ```java
 	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);

		Path<String> nomePath = root.<String> get("nome");
		Path<Integer> lojaPath = root.<Loja> get("loja").<Integer> get("id");
		Path<Integer> categoriaPath = root.join("categorias").<Integer> get("id");

		List<Predicate> predicates = new ArrayList<>();

		if (!nome.isEmpty()) {
			Predicate nomeIgual = criteriaBuilder.like(nomePath, nome);
			predicates.add(nomeIgual);
		}
		if (categoriaId != null) {
			Predicate categoriaIgual = criteriaBuilder.equal(categoriaPath, categoriaId);
			predicates.add(categoriaIgual);
		}
		if (lojaId != null) {
			Predicate lojaIgual = criteriaBuilder.equal(lojaPath, lojaId);
			predicates.add(lojaIgual);
		}

		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Produto> typedQuery = em.createQuery(query);
		
		return typedQuery.getResultList();

	}
 ```
 
 Além de passar um *array* de predicates para o método `where`, existe alguma outra forma de passarmos mais de um `predicate` a query? Como podemos criar um filtro para procurarmos por um produto que seja vendido pela casa do código, ou seja, de tecnologia?

Pesquise pelos métodos `and`, `or`, conjunction e `disjunction` da classe CriteriaBuilder e veja nosso código"!

A classe *CriteriaBuilder* permite montar um *Predicate* mais avançado, como por exemplo:
 
 ```java
     Predicate conjuncao = builder.conjunction();

    if (!nome.isEmpty()) {
        Path<String> nomeProduto = produtoRoot.<String> get("nome");
        Predicate nomeIgual = builder.like(nomeProduto, "%" + nome + "%");

        conjuncao = builder.and(nomeIgual);
    }

    if (categoriaId != null) {
        Join<Produto, List<Categoria>> join = produtoRoot.join("categorias");
        Path<Integer> categoriaProduto = join.get("id");

        conjuncao = builder.and(conjuncao,
        builder.equal(categoriaProduto, categoriaId));
    }

    if (lojaId != null) {
        Path<Loja> loja = produtoRoot.<Loja> get("loja");
        Path<Integer> id = loja.<Integer> get("id");

        conjuncao = builder.and(conjuncao, builder.equal(id, lojaId));
    }

    TypedQuery<Produto> typedQuery = em.createQuery(query.where(conjuncao));
 
 ```
 [editar código](http://jbt.github.io/markdown-editor/#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)
 