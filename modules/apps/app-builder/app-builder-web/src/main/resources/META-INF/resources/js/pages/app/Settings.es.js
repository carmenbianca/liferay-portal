/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext} from 'react';

import ToggleSwitch from '../../components/toggle-switch/ToggleSwitch.es';
import EditAppContext, {
	ADD_DEPLOYMENT,
	REMOVE_DEPLOYMENT,
} from './EditAppContext.es';

export default ({deploymentType, settings = () => <></>, subtitle, title}) => {
	const {
		dispatch,
		state: {
			app: {appDeployments},
		},
	} = useContext(EditAppContext);

	const checked = appDeployments.some(
		appDeployment => appDeployment.type === deploymentType
	);

	return (
		<>
			<div className="autofit-row mb-3 pl-4 pr-4">
				<div className="autofit-col-expand">
					<section className="autofit-section">
						<h3>{title}</h3>
						<p className="list-group-subtext">
							<small>{subtitle}</small>
						</p>
					</section>
				</div>

				<div className="autofit-col right">
					<ToggleSwitch
						checked={checked}
						onChange={checked => {
							if (checked) {
								dispatch({
									deploymentType,
									type: ADD_DEPLOYMENT,
								});
							}
							else {
								dispatch({
									deploymentType,
									type: REMOVE_DEPLOYMENT,
								});
							}
						}}
					/>
				</div>
			</div>

			{checked && settings()}
		</>
	);
};
