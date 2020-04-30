/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm from '@clayui/form';
import React, {useContext, useState} from 'react';

import AppContext from '../../../AppContext.es';
import Sidebar from '../../../components/sidebar/Sidebar.es';
import FieldsSidebarBody from './FieldsSidebarBody.es';
import FieldsSidebarSettingsBody from './FieldsSidebarSettingsBody.es';
import FieldsSidebarSettingsHeader from './FieldsSidebarSettingsHeader.es';

export default function({title}) {
	const [{focusedCustomObjectField, focusedField}] = useContext(AppContext);
	const [keywords, setKeywords] = useState('');

	const hasFocusedField = Object.keys(focusedField).length > 0;
	const hasFocusedCustomObjectField =
		Object.keys(focusedCustomObjectField).length > 0;

	const displaySettings = hasFocusedCustomObjectField || hasFocusedField;

	return (
		<Sidebar>
			<Sidebar.Header>
				<Sidebar.Title title={title} />

				{displaySettings ? (
					<FieldsSidebarSettingsHeader />
				) : (
					<ClayForm onSubmit={event => event.preventDefault()}>
						<Sidebar.SearchInput
							onSearch={keywords => setKeywords(keywords)}
						/>
					</ClayForm>
				)}
			</Sidebar.Header>

			<Sidebar.Body>
				{displaySettings ? (
					<FieldsSidebarSettingsBody />
				) : (
					<FieldsSidebarBody keywords={keywords} />
				)}
			</Sidebar.Body>
		</Sidebar>
	);
}
