/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React, {useCallback, useEffect, useRef, useState} from 'react';

import FormField from './FormField.es';

const DisplayPageModalForm = React.forwardRef((props, ref) => {
	const [subtypes, setSubtypes] = useState([]);
	const nameInput = useRef(null);
	const [error, setError] = useState(props.error);

	useEffect(() => {
		if (nameInput.current) {
			nameInput.current.focus();
		}
	}, []);

	useEffect(() => {
		setError(props.error);
	}, [props.error]);

	const onChange = useCallback(
		event => {
			setError({...error, classNameId: null, classTypeId: null});

			const select = event.target;
			const selectedMappingId =
				select.options[select.selectedIndex].value;

			const mappingType = props.mappingTypes.find(
				mappingType => mappingType.id === selectedMappingId
			);

			if (mappingType) {
				setSubtypes(mappingType.subtypes);
			}
			else {
				setSubtypes([]);
			}
		},
		[error, props.mappingTypes]
	);

	return (
		<form onSubmit={props.onSubmit} ref={ref}>
			<FormField
				error={error && error.name}
				id={`${props.namespace}name`}
				name={Liferay.Language.get('name')}
			>
				<input
					className={'form-control'}
					defaultValue={props.displayPageName}
					id={`${props.namespace}name`}
					name={`${props.namespace}name`}
					onChange={() => setError({...error, name: null})}
					ref={nameInput}
				/>
			</FormField>

			{Array.isArray(props.mappingTypes) &&
				props.mappingTypes.length > 0 && (
					<fieldset>
						<FormField
							error={error && error.classNameId}
							id={`${props.namespace}classNameId`}
							name={Liferay.Language.get('content-type')}
						>
							<select
								className="form-control"
								name={`${props.namespace}classNameId`}
								onChange={onChange}
							>
								<option value="">
									{`-- ${Liferay.Language.get(
										'not-selected'
									)} --`}
								</option>
								{props.mappingTypes.map(mappingType => (
									<option
										key={mappingType.id}
										value={mappingType.id}
									>
										{mappingType.label}
									</option>
								))}
							</select>
						</FormField>

						{Array.isArray(subtypes) && subtypes.length > 0 && (
							<FormField
								error={error && error.classTypeId}
								id={`${props.namespace}classTypeId`}
								name={Liferay.Language.get('subtype')}
							>
								<select
									className="form-control"
									name={`${props.namespace}classTypeId`}
									onChange={() =>
										setError({...error, classTypeId: null})
									}
								>
									<option value="">
										{`-- ${Liferay.Language.get(
											'not-selected'
										)} --`}
									</option>
									{subtypes.map(subtype => (
										<option
											key={subtype.id}
											value={subtype.id}
										>
											{subtype.label}
										</option>
									))}
								</select>
							</FormField>
						)}
					</fieldset>
				)}
		</form>
	);
});

DisplayPageModalForm.propTypes = {
	displayPageName: PropTypes.string,
	error: PropTypes.object,
	mappingType: PropTypes.arrayOf(
		PropTypes.shape({
			id: PropTypes.string,
			label: PropTypes.string,
			subtypes: PropTypes.arrayOf(
				PropTypes.shape({
					id: PropTypes.string,
					label: PropTypes.string,
				})
			),
		})
	),
	namespace: PropTypes.string.isRequired,
	onSubmit: PropTypes.func.isRequire,
};

export {DisplayPageModalForm};
export default DisplayPageModalForm;
