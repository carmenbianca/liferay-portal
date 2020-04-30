/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import App from './App.es';

export default function(props) {
	return (
		<div className="app-builder-root">
			<App {...props} />
		</div>
	);
}
