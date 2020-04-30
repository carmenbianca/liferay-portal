/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext} from 'react';

import {UpperToolbarInput} from '../../components/upper-toolbar/UpperToolbar.es';
import EditAppContext, {UPDATE_NAME} from './EditAppContext.es';

export default () => {
	const {
		dispatch,
		state: {
			app: {
				name: {en_US: appName},
			},
		},
	} = useContext(EditAppContext);

	const onAppNameChange = event => {
		const appName = event.target.value;

		dispatch({
			appName,
			type: UPDATE_NAME,
		});
	};

	const maxLength = 30;

	return (
		<>
			<div className="align-items-center bg-transparent card-header d-flex justify-content-between">
				<UpperToolbarInput
					maxLength={maxLength}
					onInput={onAppNameChange}
					placeholder={Liferay.Language.get('untitled-app')}
					value={appName}
				/>
			</div>

			<h4 className="card-divider mb-4"></h4>
		</>
	);
};
