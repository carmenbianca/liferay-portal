/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {createContext} from 'react';

const AppContext = createContext();

const AppContextProvider = ({
	children,
	pathFriendlyURLPublic,
	...restProps
}) => {
	const getStandaloneURL = appId =>
		`${Liferay.ThemeDisplay.getPortalURL()}${pathFriendlyURLPublic}/App${appId}`;

	return (
		<AppContext.Provider
			value={{
				getStandaloneURL,
				...restProps,
			}}
		>
			{children}
		</AppContext.Provider>
	);
};

export {AppContext, AppContextProvider};
