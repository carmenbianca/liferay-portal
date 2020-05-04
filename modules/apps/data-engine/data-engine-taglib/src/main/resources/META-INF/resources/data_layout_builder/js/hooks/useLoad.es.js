/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useIsMounted} from 'frontend-js-react-web';
import React from 'react';

const {useCallback, useRef} = React;

/**
 * Provides a way to load a module on demand.
 *
 * The returned `load()` function expects an identifying `key` for
 * the module and an entry point (ie. path to the module), and returns a
 * promise that resolves to the loaded module's default export.
 */
export default function useLoad() {
	const modules = useRef(new Map());

	const isMounted = useIsMounted();

	return useCallback(
		(key, entryPoint) => {
			if (!modules.current.get(key)) {
				modules.current.set(
					key,
					new Promise((resolve, reject) => {
						Liferay.Loader.require(
							[entryPoint],
							Plugin => {
								if (isMounted()) {
									resolve(Plugin.default);
								}
							},
							error => {
								if (isMounted()) {
									// Reset to allow future retries.
									modules.current.delete(key);
									reject(error);
								}
							}
						);
					})
				);
			}

			return modules.current.get(key);
		},
		[isMounted]
	);
}
