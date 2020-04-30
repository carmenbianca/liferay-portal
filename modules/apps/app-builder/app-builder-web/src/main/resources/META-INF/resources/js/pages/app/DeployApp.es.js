/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import ProductMenuSettings from './ProductMenuSettings.es';
import Settings from './Settings.es';
import WidgetSettings from './WidgetSettings.es';

const Divider = () => {
	return (
		<div className="autofit-row mb-4 pl-2 pr-2">
			<div className="col-md-12">
				<h4 className="card-divider"></h4>
			</div>
		</div>
	);
};

export default () => {
	return (
		<>
			<div className="autofit-row mb-4 pl-4 pr-4">
				<div className="autofit-col-expand">
					<h2>{`${Liferay.Language.get('deploy-as')}...`}</h2>
				</div>
			</div>

			<Settings
				deploymentType="widget"
				settings={WidgetSettings}
				subtitle={Liferay.Language.get('deploy-a-widget')}
				title={Liferay.Language.get('widget')}
			/>

			<Divider />

			<Settings
				deploymentType="standalone"
				subtitle={Liferay.Language.get(
					'deploy-a-standalone-app-with-a-direct-link'
				)}
				title={Liferay.Language.get('standalone')}
			/>

			<Divider />

			<Settings
				deploymentType="productMenu"
				settings={ProductMenuSettings}
				subtitle={Liferay.Language.get(
					'deploy-to-the-control-panel-or-a-site-menu'
				)}
				title={Liferay.Language.get('product-menu')}
			/>

			<Divider />
		</>
	);
};
