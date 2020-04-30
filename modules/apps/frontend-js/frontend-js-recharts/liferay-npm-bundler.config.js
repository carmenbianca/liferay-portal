/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

module.exports = {
	'create-jar': false,
	exports: {
		recharts: 'recharts',
		recharts_lib_index: 'recharts/lib/index.js',
	},
	imports: {
		'frontend-js-node-shims': {
			events: '^1.0.0',
		},
		'frontend-js-react-web': {
			react: '^16.0.0',
			'react-dom': '^16.0.0',
		},
	},
	output: 'build/node/packageRunBuild/resources',
	workdir: 'build/node/bundler',
};
