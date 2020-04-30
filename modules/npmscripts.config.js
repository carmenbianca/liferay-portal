/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const CHECK_AND_FIX_GLOBS = [
	'/{,dxp/}*.js',
	'/{,dxp/}apps/*/*/*.{js,json}',
	'/{,dxp/}apps/*/*/{src,test}/**/*.{js,scss}',
	'/{,dxp/}apps/*/*/{src}/**/*.{jsp,jspf}',
];

module.exports = {
	check: CHECK_AND_FIX_GLOBS,
	fix: CHECK_AND_FIX_GLOBS,
	preset: 'liferay-npm-scripts/src/presets/standard',
};
