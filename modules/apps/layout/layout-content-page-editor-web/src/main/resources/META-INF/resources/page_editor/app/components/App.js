/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useEffect} from 'react';
import {createPortal} from 'react-dom';

import {config} from '../config/index';
import {useSelector} from '../store/index';
import DisabledArea from './DisabledArea';
import DragPreview from './DragPreview';
import LayoutViewport from './LayoutViewport';
import Sidebar from './Sidebar';
import Toolbar from './Toolbar';

export default function App() {
	const mainItemId = useSelector(state => state.layoutData.rootItems.main);
	const masterLayoutData = useSelector(state => state.masterLayoutData);
	const languageId = useSelector(state => state.languageId);

	useEffect(() => {
		const currentLanguageDirection = config.languageDirection[languageId];
		const wrapper = document.getElementById('wrapper');

		if (wrapper) {
			wrapper.dir = currentLanguageDirection;
			wrapper.lang = languageId;
		}
	}, [languageId]);

	return (
		<>
			<DisabledArea />
			<DragPreview />
			<Toolbar />
			<LayoutViewport
				mainItemId={mainItemId}
				useMasterLayout={masterLayoutData.items}
			/>
			{createPortal(<Sidebar />, document.body)}
		</>
	);
}
