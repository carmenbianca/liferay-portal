/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {createPortal} from 'react-dom';

export function FragmentsEditorShim() {
	return createPortal(
		<div
			className="fixed-top h-100 page-editor__shim w-100"
			role="presentation"
		/>,
		document.body
	);
}
