/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useContext, useEffect, useRef} from 'react';

import TreeviewContext from './TreeviewContext';

export default function useFocus(nodeId) {
	const {state} = useContext(TreeviewContext);

	const {active, focusedNodeId} = state;

	const focusable = useRef();

	useEffect(() => {
		if (active && nodeId === focusedNodeId && focusable.current) {
			focusable.current.focus();
		}
	}, [active, focusedNodeId, nodeId]);

	return focusable;
}
