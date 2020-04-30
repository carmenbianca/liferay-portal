/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const config = require('./webpack.config');

module.exports = {
	...config,
	devServer: {
		port: 3000,
		proxy: {
			'**': 'http://0.0.0.0:8080',
		},
		publicPath: config.output.publicPath,
	},
	devtool: 'inline-source-map',
	mode: 'development',
};
