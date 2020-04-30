/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const previewSeoFireChange = (portletNamespace, data) =>
	Liferay.fire(`${portletNamespace}PreviewSeo:changed`, {data});

const previewSeoOnChange = (portletNamespace, cb) =>
	Liferay.on(`${portletNamespace}PreviewSeo:changed`, event => {
		cb(event.data);
	});

export {previewSeoFireChange, previewSeoOnChange};
