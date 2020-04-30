/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useEffect, useState} from 'react';
import {Route, Switch} from 'react-router-dom';

import ControlMenu from '../../components/control-menu/ControlMenu.es';
import {getItem} from '../../utils/client.es';
import EditApp from '../app/EditApp.es';
import ListApps from '../app/ListApps.es';
import EditFormView from '../form-view/EditFormView.es';
import ListFormViews from '../form-view/ListFormViews.es';
import EditTableView from '../table-view/EditTableView.es';
import ListTableViews from '../table-view/ListTableViews.es';
import CustomObjectNavigationBar from './CustomObjectNavigationBar.es';

export default ({
	match: {
		params: {dataDefinitionId},
		path,
	},
}) => {
	const [title, setTitle] = useState('');

	useEffect(() => {
		getItem(
			`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}`
		).then(dataDefinition => setTitle(dataDefinition.name.en_US));
	}, [dataDefinitionId]);

	return (
		<Switch>
			<Route
				component={EditFormView}
				path={[
					`${path}/form-views/add`,
					`${path}/form-views/:dataLayoutId(\\d+)`,
				]}
			/>

			<Route
				component={EditTableView}
				path={[
					`${path}/table-views/add`,
					`${path}/table-views/:dataListViewId(\\d+)`,
				]}
			/>

			<Route
				component={EditApp}
				path={[`${path}/apps/deploy`, `${path}/apps/:appId(\\d+)`]}
			/>

			<Route
				path={path}
				render={() => (
					<>
						<ControlMenu backURL="/" title={title} />
						<CustomObjectNavigationBar />

						<Switch>
							<Route
								component={ListFormViews}
								path={`${path}/form-views`}
							/>

							<Route
								component={ListTableViews}
								path={`${path}/table-views`}
							/>

							<Route component={ListApps} path={`${path}/apps`} />
						</Switch>
					</>
				)}
			/>
		</Switch>
	);
};
