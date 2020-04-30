/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

/**
 * Context for shared data, intended as a mechanism for sharing between
 * a host application that uses `usePlugins()` and its hosted plugin modules.
 */
const PluginContext = React.createContext({});

/**
 * Convenience function that returns a component that provides the passed
 * `value` as context.
 */
export const Component = value => ({children}) => (
	<PluginContext.Provider value={value}>{children}</PluginContext.Provider>
);

export default PluginContext;
