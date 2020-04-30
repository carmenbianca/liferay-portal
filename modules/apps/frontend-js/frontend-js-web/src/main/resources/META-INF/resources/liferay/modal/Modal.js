/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';
import {render} from 'frontend-js-react-web';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

import './Modal.scss';

const openModal = props => {
	// Mount in detached node; Clay will take care of appending to `document.body`.
	// See: https://github.com/liferay/clay/blob/master/packages/clay-shared/src/Portal.tsx
	render(Modal, props, document.createElement('div'));
};

const Modal = ({buttons, id, onClose, size, title, url}) => {
	const [visible, setVisible] = useState(true);

	const {observer} = useModal({
		onClose: () => {
			processClose();
		},
	});

	const getIframeUrl = () => {
		if (!url) {
			return null;
		}

		const iframeURL = new URL(url);

		const namespace = iframeURL.searchParams.get('p_p_id');

		iframeURL.searchParams.set(
			`_${namespace}_bodyCssClass`,
			'dialog-iframe-popup'
		);

		return iframeURL.toString();
	};

	const onButtonClick = ({formId, type}) => {
		if (type === 'cancel') {
			processClose();
		}
		else if (url && type === 'submit') {
			const iframe = document.querySelector('.liferay-modal iframe');

			if (iframe) {
				const iframeDocument = iframe.contentWindow.document;

				const forms = iframeDocument.querySelectorAll('form');

				if (
					forms.length !== 1 &&
					process.env.NODE_ENV === 'development'
				) {
					console.warn('There should be one form within a modal.');
				}

				if (formId) {
					const form = iframeDocument.getElementById(formId);

					if (form) {
						form.submit();
					}
				}
				else if (forms.length >= 1) {
					forms[0].submit();
				}
			}
		}
	};

	const processClose = () => {
		setVisible(false);

		if (onClose) {
			onClose();
		}
	};

	return (
		<>
			{visible && (
				<ClayModal
					className="liferay-modal"
					id={id}
					observer={observer}
					size={url && !size ? 'full-screen' : size}
				>
					<ClayModal.Header>{title}</ClayModal.Header>
					<ClayModal.Body url={getIframeUrl()} />
					{buttons && (
						<ClayModal.Footer
							last={
								<ClayButton.Group spaced>
									{buttons.map(
										(
											{
												displayType,
												formId,
												id,
												label,
												type,
											},
											index
										) => (
											<ClayButton
												displayType={displayType}
												id={id}
												key={index}
												onClick={() => {
													onButtonClick({
														formId,
														type,
													});
												}}
												type={
													type === 'cancel'
														? 'button'
														: type
												}
											>
												{label}
											</ClayButton>
										)
									)}
								</ClayButton.Group>
							}
						/>
					)}
				</ClayModal>
			)}
		</>
	);
};

Modal.propTypes = {
	buttons: PropTypes.arrayOf(
		PropTypes.shape({
			displayType: PropTypes.oneOf([
				'link',
				'primary',
				'secondary',
				'unstyled',
			]),
			formId: PropTypes.string,
			id: PropTypes.string,
			label: PropTypes.string,
			type: PropTypes.oneOf(['cancel', 'submit']),
		})
	),
	id: PropTypes.string,
	onClose: PropTypes.func,
	size: PropTypes.oneOf(['full-screen', 'lg', 'sm']),
	title: PropTypes.string,
	url: PropTypes.string,
};

export {Modal, openModal};
