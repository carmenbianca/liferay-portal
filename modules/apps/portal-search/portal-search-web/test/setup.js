/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const fs = require('fs');
const path = require('path');

const BLACKLIST = /-ace-editor/;
const VARIANTS = /-(coverage|debug|min)\.js$/;
const WHITELIST = /\.js$/;

function filter(name) {
	return (
		!VARIANTS.test(name) && !BLACKLIST.test(name) && WHITELIST.test(name)
	);
}

function walk(dir, callback) {
	fs.readdirSync(dir, {withFileTypes: true}).forEach(entry => {
		const entryPath = path.join(dir, entry.name);

		if (entry.isDirectory()) {
			walk(entryPath, callback);
		}
		else if (filter(entryPath)) {
			callback(entryPath);
		}
	});
}

beforeEach(() => {
	jest.resetModules();

	const {YUI} = require('alloy-ui/build/aui/aui');

	const _YUI = YUI();

	global.AUI = function() {
		return _YUI;
	};

	_YUI.mix(AUI, YUI);

	global.YUI = AUI;

	const build = path.join(
		path.dirname(require.resolve('alloy-ui/build/aui/aui')),
		'..'
	);

	// eslint-disable-next-line liferay/no-dynamic-require
	walk(build, source => require(source));

	global.Liferay = {
		namespace(name) {
			Liferay[name] = {};

			return Liferay[name];
		},
	};
});
