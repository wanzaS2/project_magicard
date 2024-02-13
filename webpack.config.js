const path = require("path");

module.exports = {
  entry: "./src/index.js",
  output: {
    path: `${__dirname}/dist`,
    filename: "main.js",
  },

  devServer: {
    historyApiFallback: true,
  },
};
