/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEffect, useRef} from 'react';

export default (callback, targetKeyCode, element = window) => {
	const callbackRef = useRef();

	useEffect(() => {
		callbackRef.current = callback;
	}, [callback]);

	useEffect(() => {
		const handler = () => {
			if (window.event.keyCode === targetKeyCode) {
				callbackRef.current(window.event);
			}
		};

		const current = element.current ? element.current : element;
		current.addEventListener('keydown', handler);

		return () => current.removeEventListener('keydown', handler);
	}, [element, callbackRef, targetKeyCode]);
};
