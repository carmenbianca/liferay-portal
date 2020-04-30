/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext, useState} from 'react';
import {DndProvider} from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';
import {createPortal} from 'react-dom';

import {AppContext} from '../../AppContext.es';
import {ControlMenuBase} from '../../components/control-menu/ControlMenu.es';
import CustomObjectSidebar from './CustomObjectSidebar.es';
import FormViewContextProvider from './FormViewContextProvider.es';
import FormViewUpperToolbar from './FormViewUpperToolbar.es';

const parseProps = ({dataDefinitionId, dataLayoutId, ...props}) => ({
	...props,
	dataDefinitionId: Number(dataDefinitionId),
	dataLayoutId: Number(dataLayoutId),
});

const FormViewControlMenu = ({backURL, dataLayoutId}) => {
	let title = Liferay.Language.get('new-form-view');

	if (dataLayoutId > 0) {
		title = Liferay.Language.get('edit-form-view');
	}

	return (
		<ControlMenuBase backURL={backURL} title={title} url={location.href} />
	);
};

const EditFormView = props => {
	const {
		customObjectSidebarElementId,
		dataDefinitionId,
		dataLayoutBuilder,
		dataLayoutId,
		newCustomObject,
	} = parseProps(props);
	const {basePortletURL} = useContext(AppContext);

	let backURL = `${basePortletURL}/#/custom-object/${dataDefinitionId}/form-views`;

	if (newCustomObject) {
		backURL = basePortletURL;
	}

	return (
		<DndProvider backend={HTML5Backend}>
			<FormViewContextProvider
				dataDefinitionId={dataDefinitionId}
				dataLayoutBuilder={dataLayoutBuilder}
				dataLayoutId={dataLayoutId}
			>
				<FormViewControlMenu
					backURL={backURL}
					dataLayoutId={dataLayoutId}
				/>

				<FormViewUpperToolbar newCustomObject={newCustomObject} />

				{createPortal(
					<CustomObjectSidebar />,
					document.querySelector(`#${customObjectSidebarElementId}`)
				)}
			</FormViewContextProvider>
		</DndProvider>
	);
};

export default ({dataLayoutBuilderId, ...props}) => {
	const [dataLayoutBuilder, setDataLayoutBuilder] = useState();

	if (!dataLayoutBuilder) {
		Liferay.componentReady(dataLayoutBuilderId).then(setDataLayoutBuilder);
	}

	return dataLayoutBuilder ? (
		<EditFormView dataLayoutBuilder={dataLayoutBuilder} {...props} />
	) : null;
};
