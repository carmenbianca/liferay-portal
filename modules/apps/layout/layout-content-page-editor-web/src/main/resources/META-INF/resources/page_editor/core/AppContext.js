/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

/**
 * Context for shared data, intended as a mechanism for sharing between
 * a host application that uses `usePlugins()` and its hosted plugin modules.
 */
const AppContext = React.createContext({});

/**
 * Convenience function that returns a component that provides the passed
 * `value` as context.
 */
export const Component = value => ({children}) => (
	<AppContext.Provider value={value}>{children}</AppContext.Provider>
);

export default AppContext;
