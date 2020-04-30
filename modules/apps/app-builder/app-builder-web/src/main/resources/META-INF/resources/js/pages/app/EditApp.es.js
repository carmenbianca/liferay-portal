/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useEffect, useReducer, useState} from 'react';

import ControlMenu from '../../components/control-menu/ControlMenu.es';
import {Loading} from '../../components/loading/Loading.es';
import {getItem} from '../../utils/client.es';
import DeployApp from './DeployApp.es';
import EditAppBody from './EditAppBody.es';
import EditAppContext, {UPDATE_APP, reducer} from './EditAppContext.es';
import EditAppFooter from './EditAppFooter.es';
import EditAppHeader from './EditAppHeader.es';
import MultiStepNav from './MultiStepNav.es';

export default ({
	match: {
		params: {appId, dataDefinitionId},
	},
}) => {
	const [currentStep, setCurrentStep] = useState(0);
	const [isLoading, setLoading] = useState(false);

	const [state, dispatch] = useReducer(reducer, {
		app: {
			appDeployments: [],
			dataLayoutId: null,
			dataListViewId: null,
			name: {
				en_US: '',
			},
			status: 'deployed',
		},
	});

	useEffect(() => {
		if (appId) {
			setLoading(true);

			getItem(`/o/app-builder/v1.0/apps/${appId}`)
				.then(app => {
					dispatch({
						app,
						type: UPDATE_APP,
					});
					setLoading(false);
				})
				.catch(_ => setLoading(false));
		}
	}, [appId]);

	let title = Liferay.Language.get('new-app');

	if (appId) {
		title = Liferay.Language.get('edit-app');
	}

	const getEmptyState = (description, title) => {
		return {
			description,
			title,
		};
	};

	const onCurrentStepChange = step => {
		setCurrentStep(step);
	};

	return (
		<>
			<ControlMenu backURL="../" title={title} />

			<Loading isLoading={isLoading}>
				<EditAppContext.Provider value={{dispatch, state}}>
					<div className="container-fluid container-fluid-max-lg mt-4">
						<div className="card card-root mb-0 shadowless-card">
							<EditAppHeader />

							<div className="card-body p-0 shadowless-card-body">
								<div className="autofit-row">
									<div className="col-md-12">
										<MultiStepNav
											currentStep={currentStep}
										/>
									</div>
								</div>

								{currentStep == 0 && (
									<EditAppBody
										emptyState={getEmptyState(
											Liferay.Language.get(
												'create-one-or-more-forms-to-display-the-data-held-in-your-data-object'
											),
											Liferay.Language.get(
												'there-are-no-form-views-yet'
											)
										)}
										endpoint={`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-layouts`}
										itemType="DATA_LAYOUT"
										title={Liferay.Language.get(
											'select-a-form-view'
										)}
									/>
								)}

								{currentStep == 1 && (
									<EditAppBody
										emptyState={getEmptyState(
											Liferay.Language.get(
												'create-one-or-more-tables-to-display-the-data-held-in-your-data-object'
											),
											Liferay.Language.get(
												'there-are-no-table-views-yet'
											)
										)}
										endpoint={`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-list-views`}
										itemType="DATA_LIST_VIEW"
										title={Liferay.Language.get(
											'select-a-table-view'
										)}
									/>
								)}

								{currentStep == 2 && <DeployApp />}
							</div>

							<h4 className="card-divider"></h4>

							<EditAppFooter
								currentStep={currentStep}
								onCurrentStepChange={onCurrentStepChange}
							/>
						</div>
					</div>
				</EditAppContext.Provider>
			</Loading>
		</>
	);
};
