/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const preset = require('liferay-npm-scripts/src/presets/standard');

module.exports = {
	build: {
		dependencies: [
			...preset.build.dependencies,
			'dynamic-data-mapping-form-field-type',
			'dynamic-data-mapping-form-renderer',
		],
	},
	preset: 'liferay-npm-scripts/src/presets/standard',
};
