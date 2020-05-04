/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

const {lazy, useCallback, useRef} = React;

/**
 * Returns a component that takes a `pluginId` and a `getInstance`
 * function (for obtaining a promise of a plugin instance) and wraps it
 * in a `React.lazy` wrapper.
 *
 * The supplied callback will be called with the plugin instance once the
 * promise resolves, and should return something to be rendered.
 */
export default function useLazy(callback) {
	const components = useRef(new Map());

	return useCallback(
		({getInstance, pluginId}) => {
			if (!components.current.has(pluginId)) {
				const plugin = getInstance(pluginId);

				const Component = lazy(() => {
					return plugin.then(instance => {
						return {
							default: () => {
								if (instance) {
									return callback({instance});
								}
								else {
									return null;
								}
							},
						};
					});
				});

				components.current.set(pluginId, Component);
			}

			const Component = components.current.get(pluginId);

			return <Component />;
		},
		[callback]
	);
}
