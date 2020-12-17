module.exports = app => {
    app.get('/atendimentos', (req, res) => {
        res.send('Você esta na rota de atendimento e realizando um get')
    });

    app.post('/atendimentos', (req, res) => {
        res.send('Você esta na rota de atendimento e realizando um post')
    });
}