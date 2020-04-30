/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import {ClayInput} from '@clayui/form';
import ClayModal, {useModal} from '@clayui/modal';
import {RuleEditor} from 'dynamic-data-mapping-form-builder';
import React, {useContext, useEffect, useRef, useState} from 'react';

import AppContext from '../../AppContext.es';
import DataLayoutBuilderContext from '../../data-layout-builder/DataLayoutBuilderContext.es';
import {getItem} from '../../utils/client.es';

class RuleEditorWrapper extends RuleEditor {
	getChildContext() {
		return {
			store: {
				editingLanguageId: 'en_US',
			},
		};
	}
}

const RuleEditorModalContent = ({onClose, rule}) => {
	const ruleEditorRef = useRef();
	const [ruleEditor, setRuleEditor] = useState(null);

	const [
		{
			config: {ruleSettings},
			spritemap,
		},
	] = useContext(AppContext);

	const [dataLayoutBuilder] = useContext(DataLayoutBuilderContext);
	const {pages} = dataLayoutBuilder.getStore();

	const [state, setState] = useState({
		isLoading: true,
		roles: [],
	});

	useEffect(() => {
		const {isLoading, roles} = state;

		if (isLoading || ruleEditor !== null) {
			return;
		}

		const ruleEditorWrapper = new RuleEditorWrapper(
			{
				...ruleSettings,
				actions: [],
				conditions: [],
				events: {
					ruleAdded: rule => {
						dataLayoutBuilder.dispatch('ruleAdded', rule);
						onClose();
					},
					ruleCancelled: () => {},
					ruleDeleted: () => {},
					ruleEdited: rule => {
						dataLayoutBuilder.dispatch('ruleEdited', rule);
						onClose();
					},
				},
				key: 'create',
				pages,
				ref: 'RuleEditor',
				roles,
				rule,
				spritemap,
			},
			ruleEditorRef.current
		);

		setRuleEditor(ruleEditorWrapper);
	}, [
		dataLayoutBuilder,
		onClose,
		pages,
		ruleEditor,
		ruleEditorRef,
		rule,
		ruleSettings,
		spritemap,
		state,
	]);

	useEffect(() => {
		return () => ruleEditor && ruleEditor.dispose();
	}, [ruleEditor]);

	useEffect(() => {
		getItem('/o/headless-admin-user/v1.0/roles').then(
			({items: roles = []}) => {
				roles = roles.map(({id, name}) => ({
					id: `${id}`,
					label: name,
					name,
					value: `${id}`,
				}));

				setState(prevState => ({
					...prevState,
					isLoading: false,
					roles,
				}));
			}
		);
	}, []);

	return (
		<>
			<ClayModal.Header>
				{rule
					? Liferay.Language.get('edit-rule')
					: Liferay.Language.get('add-rule')}
			</ClayModal.Header>
			<ClayModal.Header withTitle={false}>
				<ClayInput.Group className="pl-4 pr-4">
					<ClayInput.GroupItem>
						<ClayInput
							aria-label={Liferay.Language.get('untitled-rule')}
							className="form-control-inline"
							placeholder={Liferay.Language.get('untitled-rule')}
							type="text"
						/>
					</ClayInput.GroupItem>
				</ClayInput.Group>
			</ClayModal.Header>
			<ClayModal.Body>
				<div className="pl-4 pr-4" ref={ruleEditorRef}></div>
			</ClayModal.Body>
			<ClayModal.Footer
				last={
					<ClayButton.Group spaced>
						<ClayButton displayType="secondary" onClick={onClose}>
							{Liferay.Language.get('cancel')}
						</ClayButton>
						<ClayButton
							onClick={() =>
								rule
									? ruleEditor.handleRuleEdited()
									: ruleEditor.handleRuleAdded()
							}
						>
							{Liferay.Language.get('save')}
						</ClayButton>
					</ClayButton.Group>
				}
			/>
		</>
	);
};

const RuleEditorModal = ({isVisible, onClose, rule}) => {
	const {observer} = useModal({
		onClose,
	});

	if (!isVisible) {
		return null;
	}

	return (
		<ClayModal
			className="data-layout-builder-rule-editor-modal"
			observer={observer}
			size="full-screen"
		>
			<RuleEditorModalContent onClose={onClose} rule={rule} />
		</ClayModal>
	);
};

export default RuleEditorModal;
