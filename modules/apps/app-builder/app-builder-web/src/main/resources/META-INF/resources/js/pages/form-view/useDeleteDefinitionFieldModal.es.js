/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button/lib/Button';
import {Context as ClayModalContext} from '@clayui/modal';
import ClayPanel from '@clayui/panel';
import {DataDefinitionUtils} from 'data-engine-taglib';
import React, {useContext} from 'react';

import {getItem} from '../../utils/client.es';
import FormViewContext from './FormViewContext.es';

export default callback => {
	const [{dataDefinition, dataDefinitionId, fieldTypes}] = useContext(
		FormViewContext
	);
	const [{onClose}, dispatchModal] = useContext(ClayModalContext);

	return fieldName => {
		const {fieldType, label} = DataDefinitionUtils.getDataDefinitionField(
			dataDefinition,
			fieldName
		);
		const {label: fieldTypeLabel} = fieldTypes.find(({name}) => {
			return name === fieldType;
		});

		return getItem(
			`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-definition-field-links?fieldName=${fieldName}`
		).then(({dataLayouts, dataListViews}) => {
			dispatchModal({
				payload: {
					body: (
						<>
							<ClayPanel
								className="remove-object-field-panel"
								displayTitle={Liferay.Language.get('field')}
								displayType="secondary"
							>
								<ClayPanel.Body>
									<div>
										<label>
											{Liferay.Language.get('name')}:
										</label>
										<span>{fieldName}</span>
									</div>
									<div>
										<label>
											{Liferay.Language.get('label')}:
										</label>
										<span>
											{
												label[
													themeDisplay.getLanguageId()
												]
											}
										</span>
									</div>
									<div>
										<label>
											{Liferay.Language.get('type')}:
										</label>
										<span>{fieldTypeLabel}</span>
									</div>
								</ClayPanel.Body>
							</ClayPanel>

							<p className="remove-object-field-message">
								{dataLayouts.length === 0 &&
								dataListViews.length === 0
									? Liferay.Language.get(
											'delete-definition-field-confirmation'
									  )
									: Liferay.Language.get(
											'delete-definition-field-warning'
									  )}
							</p>

							{dataLayouts.length > 0 && (
								<ClayPanel
									className="remove-object-field-panel"
									displayTitle={Liferay.Language.get(
										'form-views'
									)}
									displayType="secondary"
								>
									<ClayPanel.Body>
										{dataLayouts.map(
											(dataLayoutName, index) => (
												<label
													className="d-block"
													key={index}
												>{`${index +
													1}. ${dataLayoutName}`}</label>
											)
										)}
									</ClayPanel.Body>
								</ClayPanel>
							)}

							{dataListViews.length > 0 && (
								<ClayPanel
									className="remove-object-field-panel"
									displayTitle={Liferay.Language.get(
										'table-views'
									)}
									displayType="secondary"
								>
									<ClayPanel.Body>
										{dataListViews.map(
											(dataListViewName, index) => (
												<label
													className="d-block"
													key={index}
												>{`${index +
													1}. ${dataListViewName}`}</label>
											)
										)}
									</ClayPanel.Body>
								</ClayPanel>
							)}
						</>
					),
					footer: [
						<></>,
						<></>,
						<ClayButton.Group key={0} spaced>
							<ClayButton
								displayType="secondary"
								key={1}
								onClick={onClose}
							>
								{Liferay.Language.get('cancel')}
							</ClayButton>
							<ClayButton
								key={2}
								onClick={() => {
									callback(fieldName);

									onClose();
								}}
							>
								{Liferay.Language.get('delete')}
							</ClayButton>
						</ClayButton.Group>,
					],
					header: Liferay.Language.get('delete-from-object'),
					size: 'md',
					status: 'warning',
				},
				type: 1,
			});
		});
	};
};
