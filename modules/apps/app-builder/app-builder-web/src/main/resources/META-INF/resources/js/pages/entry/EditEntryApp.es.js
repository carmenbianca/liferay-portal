/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {AppContextProvider} from '../../AppContext.es';
import EditEntry from './EditEntry.es';

export default props => {
	return (
		<AppContextProvider {...props}>
			<EditEntry {...props} />
		</AppContextProvider>
	);
};
