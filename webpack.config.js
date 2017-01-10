var webpack = require('webpack');
var path = require('path');

var BUILD_DIR = path.resolve(__dirname, 'public/client');
var APP_DIR = path.resolve(__dirname, 'public/app');

var config = {
  entry:
      APP_DIR + '/index.jsx',
  output: {
    path: BUILD_DIR,
    filename: 'bundle.js'
},
  module : {
    preLoaders: [
        {
            test: /\.js$/,
            exclude: /node_modules/,
            loader: 'jshint-loader'
        }
    ],
    loaders : [
      {
        test : /\.jsx?/,
        include : APP_DIR,
        loader : 'babel'
      }
    ]
  }
}

module.exports = config;
