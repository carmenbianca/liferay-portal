/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import ThemeContext from './ThemeContext.es';
import Flags from './components/Flags.es';

export default function({context, props}) {
	return (
		<ThemeContext.Provider value={context}>
			<Flags {...props} />
		</ThemeContext.Provider>
	);
}
