/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayModalProvider} from '@clayui/modal';
import React from 'react';
import {DndProvider} from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';

import {AppContextProvider} from './AppContext.es';
import ListCustomObjects from './pages/custom-object/ListCustomObjects.es';
import ViewCustomObject from './pages/custom-object/ViewCustomObject.es';

export default props => (
	<DndProvider backend={HTML5Backend}>
		<AppContextProvider {...props}>
			<ClayModalProvider>
				<Router>
					<div className="custom-object-app">
						<Switch>
							<Route
								component={ListCustomObjects}
								exact
								path="/"
							/>

							<Route
								component={ViewCustomObject}
								path="/custom-object/:dataDefinitionId(\d+)"
							/>
						</Switch>
					</div>
				</Router>
			</ClayModalProvider>
		</AppContextProvider>
	</DndProvider>
);
