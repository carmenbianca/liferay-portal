/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';

import {AppContextProvider} from '../../AppContext.es';
import ListEntries from './ListEntries.es';
import {PermissionsContextProvider} from './PermissionsContext.es';
import ViewEntry from './ViewEntry.es';

export default function(props) {
	return (
		<div className="app-builder-root">
			<AppContextProvider {...props}>
				<PermissionsContextProvider
					dataDefinitionId={props.dataDefinitionId}
				>
					<Router>
						<Switch>
							<Route component={ListEntries} exact path="/" />
							<Route
								component={ViewEntry}
								path="/entries/:entryIndex(\d+)"
							/>
						</Switch>
					</Router>
				</PermissionsContextProvider>
			</AppContextProvider>
		</div>
	);
}
