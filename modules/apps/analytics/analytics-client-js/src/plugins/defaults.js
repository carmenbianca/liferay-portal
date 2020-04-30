/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import blogs from './blogs';
import custom from './custom';
import documents from './documents';
import forms from './forms';
import resolution from './resolution';
import scrolling from './scrolling';
import timing from './timing';
import webContents from './web-contents';

export {blogs, documents, forms, resolution, scrolling, timing, webContents};
export default [
	// Resolution should come first, because it chages the context

	resolution,

	blogs,
	custom,
	documents,
	forms,
	scrolling,
	timing,
	webContents,
];
