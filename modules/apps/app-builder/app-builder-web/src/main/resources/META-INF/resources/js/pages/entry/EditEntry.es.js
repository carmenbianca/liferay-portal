/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';
import React, {useCallback, useContext, useEffect, useState} from 'react';

import {AppContext} from '../../AppContext.es';
import Button from '../../components/button/Button.es';
import {ControlMenuBase} from '../../components/control-menu/ControlMenu.es';
import {addItem, updateItem} from '../../utils/client.es';
import {successToast} from '../../utils/toast.es';

export const EditEntry = ({
	dataDefinitionId,
	dataRecordId,
	ddmForm,
	redirect,
}) => {
	const {basePortletURL} = useContext(AppContext);

	const onCancel = useCallback(() => {
		if (redirect) {
			Liferay.Util.navigate(redirect);
		}
		else {
			Liferay.Util.navigate(basePortletURL);
		}
	}, [basePortletURL, redirect]);

	const onSave = useCallback(() => {
		const {pages} = ddmForm;
		const visitor = new PagesVisitor(pages);

		ddmForm.validate().then(validForm => {
			if (!validForm) {
				return;
			}

			const dataRecord = {
				dataRecordValues: {},
			};

			visitor.mapFields(({fieldName, localizable, value}) => {
				if (localizable) {
					dataRecord.dataRecordValues[fieldName] = {
						[themeDisplay.getLanguageId()]: value,
					};
				}
				else {
					dataRecord.dataRecordValues[fieldName] = value;
				}
			});

			const openSuccessToast = isNew => {
				const message = isNew
					? Liferay.Language.get('an-entry-was-added')
					: Liferay.Language.get('an-entry-was-updated');

				successToast(message);
			};

			if (dataRecordId !== '0') {
				updateItem(
					`/o/data-engine/v2.0/data-records/${dataRecordId}`,
					dataRecord
				).then(() => {
					openSuccessToast(false);
					onCancel();
				});
			}
			else {
				addItem(
					`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-records`,
					dataRecord
				).then(() => {
					openSuccessToast(true);
					onCancel();
				});
			}
		});
	}, [dataDefinitionId, dataRecordId, ddmForm, onCancel]);

	useEffect(() => {
		const formNode = ddmForm.getFormNode();
		const onSubmit = () => onSave();

		formNode.addEventListener('submit', onSubmit);

		return () => formNode.removeEventListener('submit', onSubmit);
	}, [ddmForm, onSave]);

	return (
		<>
			<ControlMenuBase
				backURL={redirect ? redirect : `${basePortletURL}/#/`}
				title={
					dataRecordId !== '0'
						? Liferay.Language.get('edit-entry')
						: Liferay.Language.get('add-entry')
				}
				url={location.href}
			/>

			<ClayButton.Group className="app-builder-form-buttons" spaced>
				<Button onClick={onSave}>{Liferay.Language.get('save')}</Button>
				<Button displayType="secondary" onClick={onCancel}>
					{Liferay.Language.get('cancel')}
				</Button>
			</ClayButton.Group>
		</>
	);
};

export default ({editEntryContainerElementId, ...props}) => {
	const [ddmForm, setDDMForm] = useState();

	if (!ddmForm) {
		Liferay.componentReady(editEntryContainerElementId).then(setDDMForm);
	}

	return ddmForm ? <EditEntry ddmForm={ddmForm} {...props} /> : null;
};
