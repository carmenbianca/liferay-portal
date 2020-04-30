/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {createContext, useEffect, useState} from 'react';

import {hasListPermissions} from './utils/client.es';

const AppContext = createContext({});

const AppContextProvider = ({children, ...context}) => {
	const [canCreateThread, setCanCreateThread] = useState(false);
	const [section, setSection] = useState({});

	useEffect(() => {
		hasListPermissions('create', context.siteKey).then(value =>
			setCanCreateThread(value)
		);
	}, [context.siteKey]);

	return (
		<AppContext.Provider
			value={{
				...context,
				canCreateThread,
				section,
				setSection,
			}}
		>
			{children}
		</AppContext.Provider>
	);
};

export {AppContext, AppContextProvider};
