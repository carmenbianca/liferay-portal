/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import CKEditor from 'ckeditor4-react';
import React from 'react';

const BASEPATH = '/o/frontend-editor-ckeditor-web/ckeditor/';

const Editor = props => {
	return <CKEditor {...props} />;
};

CKEditor.editorUrl = `${BASEPATH}ckeditor.js`;
window.CKEDITOR_BASEPATH = BASEPATH;

export {Editor};
