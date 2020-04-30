/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import NoCommentsMessageIcon from './NoCommentsMessageIcon';

export default function NoCommentsMessage() {
	return (
		<div className="p-4 text-center">
			<NoCommentsMessageIcon />

			<h1 className="h4">
				{Liferay.Language.get('there-are-no-comments-yet')}
			</h1>

			<p className="small text-secondary">
				{Liferay.Language.get('select-a-fragment-to-add-a-comment')}
			</p>
		</div>
	);
}
