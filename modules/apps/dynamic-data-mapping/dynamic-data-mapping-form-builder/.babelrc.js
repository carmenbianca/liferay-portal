/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

module.exports = {
	liferay: {
		excludes: {
			// eslint-disable-next-line liferay-portal/no-explicit-extend
			presets: ['@babel/preset-react'],
		},
	},
	plugins: [
		[
			'incremental-dom',
			{
				components: true,
				namespaceAttributes: true,
				prefix: 'IncrementalDOM',
				runtime: 'iDOMHelpers',
			},
		],
	],
};
