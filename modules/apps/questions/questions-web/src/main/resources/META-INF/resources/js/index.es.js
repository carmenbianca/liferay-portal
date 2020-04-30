/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import App from './App.es';

export default function(props) {
	return (
		<div className="questions-root">
			<App {...props} />
		</div>
	);
}
