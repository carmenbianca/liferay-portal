/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayModalProvider} from '@clayui/modal';
import React from 'react';

import {AppContextProvider} from '../../AppContext.es';
import EditFormView from './EditFormView.es';

const EditFormViewApp = ({basePortletURL, ...props}) => {
	return (
		<AppContextProvider basePortletURL={basePortletURL}>
			<ClayModalProvider>
				<EditFormView {...props} />
			</ClayModalProvider>
		</AppContextProvider>
	);
};

export default EditFormViewApp;
