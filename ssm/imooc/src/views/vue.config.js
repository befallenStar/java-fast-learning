module.exports = {
    publicPath: './',
    devServer: {
        host: 'localhost',
        port: '8181',
        https: false,
        hot: true,
        open: true,
        proxy: {
            '/api': {
                target: 'http://localhost:8888/',
                secure: false, //带SSL https
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}