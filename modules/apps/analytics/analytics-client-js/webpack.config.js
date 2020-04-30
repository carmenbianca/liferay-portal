/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const webpack = require('webpack');
const buildFolder = `${__dirname}/build`;
const buildName = 'analytics-all-min.js';

const devConfig = {
	devtool: 'inline-source-map',
	mode: 'development',
	optimization: {
		minimize: false,
	},
	watch: true,
};

const prodConfig = {
	mode: 'production',
	optimization: {
		minimize: true,
	},
};

const config = {
	entry: [
		'core-js/fn/array/from',
		'core-js/fn/array/find',
		'core-js/es6/symbol',
		'core-js/fn/promise',
		'whatwg-fetch',
		'./src/analytics.js',
	],
	module: {
		rules: [
			{
				exclude: /(node_modules)/,
				test: /\.js$/,
				use: {
					loader: 'babel-loader',
					options: {
						compact: false,
					},
				},
			},
		],
	},
	output: {
		filename: buildName,
		path: buildFolder,
	},
	plugins: [new webpack.optimize.ModuleConcatenationPlugin()],
};

module.exports = env => {
	return env === 'development'
		? {
				...config,
				...devConfig,
		  }
		: {
				...config,
				...prodConfig,
		  };
};
