/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const path = require('path');

/**
 * We use liferay-npm-scripts to perform linting in a controlled way, but we
 * also try to expose its configuration here so it can be picked up by editors.
 */
let config = {};

try {
	config = require('liferay-npm-scripts/src/config/eslint.config');
}
catch (error) {
	throw new Error(
		'liferay-npm-scripts is not installed; please run "ant setup-sdk"'
	);
}

config = {
	...config,
	globals: {
		...config.globals,
		MODULE_PATH: true,
	},
	rules: {
		'no-empty': ['error', {allowEmptyCatch: true}],
		'notice/notice': [
			'error',
			{
				templateFile: path.join(__dirname, 'copyright.js'),
			},
		],
	},
};

module.exports = config;
