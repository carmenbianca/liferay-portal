/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';

import {AppContextProvider} from './AppContext.es';
import {ErrorBoundary} from './components/ErrorBoundary.es';
import NavigationBar from './pages/NavigationBar.es';
import EditAnswer from './pages/answers/EditAnswer.es';
import Home from './pages/home/Home';
import UserActivity from './pages/home/UserActivity.es';
import EditQuestion from './pages/questions/EditQuestion.es';
import NewQuestion from './pages/questions/NewQuestion.es';
import Question from './pages/questions/Question.es';
import Questions from './pages/questions/Questions.es';
import Tags from './pages/tags/Tags.es';

export default props => (
	<AppContextProvider {...props}>
		<Router>
			<ErrorBoundary>
				<div>
					<Route component={Home} exact path="/" />
					<Route component={Home} exact path="/questions" />
					<Route
						component={UserActivity}
						exact
						path="/activity/:creatorId"
					/>

					<Route
						path="/questions/:sectionTitle"
						render={({match: {path}}) => (
							<>
								<NavigationBar />

								<Switch>
									<Route
										component={EditAnswer}
										exact
										path={`${path}/:questionId/answers/:answerId/edit`}
									/>
									<Route
										component={Questions}
										exact
										path={`${path}/creator/:creatorId`}
									/>
									<Route
										component={Questions}
										exact
										path={`${path}/tag/:tag`}
									/>
									<Route
										component={NewQuestion}
										exact
										path={`${path}/new`}
									/>
									<Route
										component={Tags}
										exact
										path={`${path}/tags`}
									/>
									<Route
										component={Question}
										exact
										path={`${path}/:questionId`}
									/>
									<Route
										component={EditQuestion}
										exact
										path={`${path}/:questionId/edit`}
									/>
									<Route
										component={Questions}
										exact
										path={`${path}/`}
									/>
								</Switch>
							</>
						)}
					/>
				</div>
			</ErrorBoundary>
		</Router>
	</AppContextProvider>
);
