/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import {ClayTooltipProvider} from '@clayui/tooltip';
import classNames from 'classnames';
import {getRepeatedIndex} from 'dynamic-data-mapping-form-renderer';
import React, {useMemo} from 'react';

function FieldBase({
	children,
	displayErrors,
	editingLanguageId,
	errorMessage,
	label,
	localizedValue = {},
	name,
	onClick,
	onRemoveButton,
	onRepeatButton,
	readOnly,
	repeatable,
	required,
	showLabel = true,
	spritemap,
	tip,
	tooltip,
	valid,
	visible,
}) {
	const localizedValueArray = useMemo(() => {
		const languageValues = [];

		Object.keys(localizedValue).forEach(key => {
			if (key !== editingLanguageId && localizedValue[key] !== '') {
				languageValues.push({
					name: name.replace(editingLanguageId, key),
					value: localizedValue[key],
				});
			}
		});

		return languageValues;
	}, [localizedValue, editingLanguageId, name]);
	const repeatedIndex = useMemo(() => getRepeatedIndex(name), [name]);

	return (
		<ClayTooltipProvider>
			<div
				className={classNames('form-group', {
					'has-error': displayErrors && errorMessage && !valid,
					hide: !visible,
				})}
				data-field-name={name}
				onClick={onClick}
			>
				{repeatable && (
					<div className="lfr-ddm-form-field-repeatable-toolbar">
						{repeatable && repeatedIndex > 0 && (
							<ClayButton
								className="ddm-form-field-repeatable-delete-button p-0"
								disabled={readOnly}
								onClick={onRemoveButton}
								small
								type="button"
							>
								<ClayIcon
									spritemap={spritemap}
									symbol="trash"
								/>
							</ClayButton>
						)}

						<ClayButton
							className="ddm-form-field-repeatable-add-button p-0"
							disabled={readOnly}
							onClick={onRepeatButton}
							small
							type="button"
						>
							<ClayIcon spritemap={spritemap} symbol="plus" />
						</ClayButton>
					</div>
				)}

				{((label && showLabel) ||
					required ||
					tooltip ||
					repeatable) && (
					<p
						className={classNames({
							'ddm-empty': !showLabel && !required,
							'ddm-label': showLabel,
						})}
					>
						{label && showLabel && label}

						{required && spritemap && (
							<span className="reference-mark">
								<ClayIcon
									spritemap={spritemap}
									symbol="asterisk"
								/>
							</span>
						)}

						{tooltip && (
							<div className="ddm-tooltip">
								<ClayIcon
									data-tooltip-align="right"
									spritemap={spritemap}
									symbol="question-circle-full"
									title={tooltip}
								/>
							</div>
						)}
					</p>
				)}

				{children}

				{localizedValueArray.length > 0 &&
					localizedValueArray.map(language => (
						<input
							key={language.name}
							name={language.name}
							type="hidden"
							value={language.value}
						/>
					))}

				{tip && <span className="form-text">{tip}</span>}

				{displayErrors && errorMessage && !valid && (
					<span className="form-feedback-group">
						<div className="form-feedback-item">{errorMessage}</div>
					</span>
				)}
			</div>
		</ClayTooltipProvider>
	);
}

/**
 * This Proxy connects to the store to send the changes directly to the store. This
 * should be replaced when we have a communication with a Store/Provider in React.
 */
const FieldBaseProxy = ({dispatch, name, store, ...otherProps}) => (
	<FieldBase
		{...otherProps}
		editingLanguageId={store.editingLanguageId}
		name={name}
		onRemoveButton={() => dispatch('fieldRemoved', name)}
		onRepeatButton={() => dispatch('fieldRepeated', name)}
	/>
);

export {FieldBase, FieldBaseProxy};
