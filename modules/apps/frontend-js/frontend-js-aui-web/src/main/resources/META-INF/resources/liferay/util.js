/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

(function (A, Liferay) {
	A.use('aui-base-lang');

	var AArray = A.Array;

	var Lang = A.Lang;

	var EVENT_CLICK = 'click';

	var MAP_TOGGLE_STATE = {
		false: {
			cssClass: 'controls-hidden',
			iconCssClass: 'hidden',
			state: 'hidden',
		},
		true: {
			cssClass: 'controls-visible',
			iconCssClass: 'view',
			state: 'visible',
		},
	};

	var REGEX_SUB = /\{\s*([^|}]+?)\s*(?:\|([^}]*))?\s*\}/g;

	var SRC_HIDE_LINK = {
		src: 'hideLink',
	};

	var STR_RIGHT_SQUARE_BRACKET = ']';

	var TPL_LEXICON_ICON =
		'<svg class="lexicon-icon lexicon-icon-{0} {1}" focusable="false" role="image">' +
		'<use data-href="' +
		themeDisplay.getPathThemeImages() +
		'/lexicon/icons.svg#{0}" />' +
		'</svg>';

	var Window = {
		_map: {},

		getById(id) {
			var instance = this;

			return instance._map[id];
		},
	};

	var Util = {
		_getEditableInstance(title) {
			var editable = Util._EDITABLE;

			if (!editable) {
				editable = new A.Editable({
					after: {
						contentTextChange(event) {
							var instance = this;

							if (!event.initial) {
								var title = instance.get('node');

								var portletTitleEditOptions = title.getData(
									'portletTitleEditOptions'
								);

								Util.savePortletTitle({
									doAsUserId:
										portletTitleEditOptions.doAsUserId,
									plid: portletTitleEditOptions.plid,
									portletId:
										portletTitleEditOptions.portletId,
									title: event.newVal,
								});
							}
						},
						startEditing() {
							var instance = this;

							var Layout = Liferay.Layout;

							if (Layout) {
								instance._dragListener = Layout.getLayoutHandler().on(
									'drag:start',
									() => {
										instance.fire('save');
									}
								);
							}

							var title = instance.get('node');

							instance._titleListener = title.on(
								'mouseupoutside',
								(event) => {
									var editable = Util._getEditableInstance(
										title
									);

									if (
										!editable
											.get('boundingBox')
											.contains(event.target)
									) {
										editable.save();
									}
								}
							);
						},
						stopEditing() {
							var instance = this;

							if (instance._dragListener) {
								instance._dragListener.detach();
							}

							if (instance._titleListener) {
								instance._titleListener.detach();
							}
						},
					},
					cssClass: 'lfr-portlet-title-editable',
					node: title,
				});

				editable.get('cancelButton').icon = 'times';
				editable.get('saveButton').icon = 'check';

				Util._EDITABLE = editable;
			}

			return editable;
		},

		addInputCancel() {
			A.use('aui-button-search-cancel', (A) => {
				new A.ButtonSearchCancel({
					trigger:
						'input[type=password], input[type=search], input.clearable, input.search-query',
				});
			});

			Util.addInputCancel = function () {};
		},

		checkAll(form, name, allBox, selectClassName) {
			if (form) {
				form = Util.getDOM(form);

				if (typeof form === 'string') {
					form = document.querySelector(form);
				}

				allBox = Util.getDOM(allBox);

				if (typeof allBox === 'string') {
					allBox = document.querySelector(allBox);
				}

				let selector;

				if (Array.isArray(name)) {
					selector =
						'input[name=' +
						name.join('], input[name=') +
						STR_RIGHT_SQUARE_BRACKET;
				}
				else {
					selector = 'input[name=' + name + STR_RIGHT_SQUARE_BRACKET;
				}

				const allBoxChecked = allBox.checked;

				const uploadedItems = Array.from(
					form.querySelectorAll(selector)
				);

				uploadedItems.forEach((item) => {
					if (!item.disabled) {
						item.checked = allBoxChecked;
					}
				});

				if (selectClassName) {
					const selectItem = form.querySelector(selectClassName);

					if (allBoxChecked) {
						selectItem.classList.add('info');
					}
					else {
						selectItem.classList.remove('info');
					}
				}
			}
		},

		checkAllBox(form, name, allBox) {
			let totalOn = 0;

			if (form) {
				form = Util.getDOM(form);

				if (typeof form === 'string') {
					form = document.querySelector(form);
				}

				allBox = Util.getDOM(allBox);

				if (typeof allBox === 'string') {
					allBox =
						document.querySelector(allBox) ||
						form.querySelector(`input[name="${allBox}"]`);
				}

				const inputs = Array.from(
					form.querySelectorAll('input[type=checkbox]')
				);

				if (!Array.isArray(name)) {
					name = [name];
				}

				let totalBoxes = 0;

				inputs.forEach((input) => {
					if (
						input.id !== allBox.id ||
						(input.id !== allBox.name &&
							name.indexOf(input.name) > -1)
					) {
						totalBoxes++;

						if (input.checked) {
							totalOn++;
						}
					}
				});

				allBox.checked = totalBoxes === totalOn;
			}

			return totalOn;
		},

		checkTab(box) {
			if (document.all && window.event.keyCode == 9) {
				box.selection = document.selection.createRange();

				setTimeout(() => {
					Util.processTab(box.id);
				}, 0);
			}
		},

		disableElements(el) {
			const currentElement = Util.getElement(el);

			if (currentElement) {
				var children = currentElement.getElementsByTagName('*');

				var emptyFnFalse = function () {
					return false;
				};

				for (var i = children.length - 1; i >= 0; i--) {
					var item = children[i];

					item.style.cursor = 'default';

					item.onclick = emptyFnFalse;
					item.onmouseover = emptyFnFalse;
					item.onmouseout = emptyFnFalse;
					item.onmouseenter = emptyFnFalse;
					item.onmouseleave = emptyFnFalse;

					item.action = '';
					item.disabled = true;
					item.href = 'javascript:;';
					item.onsubmit = emptyFnFalse;
				}
			}
		},

		disableFormButtons(inputs, form) {
			inputs.attr('disabled', true);
			inputs.setStyle('opacity', 0.5);

			if (A.UA.gecko) {
				A.getWin().on('unload', () => {
					inputs.attr('disabled', false);
				});
			}
			else if (A.UA.safari) {
				A.use('node-event-html5', (A) => {
					A.getWin().on('pagehide', () => {
						Util.enableFormButtons(inputs, form);
					});
				});
			}
		},

		disableToggleBoxes(checkBoxId, toggleBoxId, checkDisabled) {
			const checkBox = document.getElementById(checkBoxId);
			const toggleBox = document.getElementById(toggleBoxId);

			if (checkBox && toggleBox) {
				toggleBox.disabled = checkDisabled && checkBox.checked;

				checkBox.addEventListener(EVENT_CLICK, () => {
					toggleBox.disabled = !toggleBox.disabled;
				});
			}
		},

		enableFormButtons(inputs) {
			Util._submitLocked = null;

			Util.toggleDisabled(inputs, false);
		},

		/**
		 * @deprecated As of Athanasius (7.3.x), with no direct replacement
		 */
		escapeCDATA(str) {
			return str.replace(/<!\[CDATA\[|\]\]>/gi, (match) => {
				var str = '';

				if (match == ']]>') {
					str = ']]&gt;';
				}
				else if (match == '<![CDATA[') {
					str = '&lt;![CDATA[';
				}

				return str;
			});
		},

		forcePost(link) {
			const currentElement = Util.getElement(link);

			if (currentElement) {
				const url = currentElement.getAttribute('href');

				const newWindow =
					currentElement.getAttribute('target') == '_blank';

				const hrefFm = document.hrefFm;

				if (newWindow) {
					hrefFm.setAttribute('target', '_blank');
				}

				submitForm(hrefFm, url, !newWindow);

				Util._submitLocked = null;
			}
		},

		getAttributes(el, attributeGetter) {
			var result = null;

			if (el) {
				el = Util.getDOM(el);

				if (el.jquery) {
					el = el[0];
				}

				result = {};

				var getterFn = typeof attributeGetter === 'function';
				var getterString = typeof attributeGetter === 'string';

				var attrs = el.attributes;
				var length = attrs.length;

				while (length--) {
					var attr = attrs[length];
					var name = attr.nodeName.toLowerCase();
					var value = attr.nodeValue;

					if (getterString) {
						if (name.indexOf(attributeGetter) === 0) {
							name = name.substr(attributeGetter.length);
						}
						else {
							continue;
						}
					}
					else if (getterFn) {
						value = attributeGetter(value, name, attrs);

						if (value === false) {
							continue;
						}
					}

					result[name] = value;
				}
			}

			return result;
		},

		getColumnId(str) {
			var columnId = str.replace(/layout-column_/, '');

			return columnId;
		},

		getGeolocation(success, fallback, options) {
			if (success && navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(
					(position) => {
						success(
							position.coords.latitude,
							position.coords.longitude,
							position
						);
					},
					fallback,
					options
				);
			}
			else if (fallback) {
				fallback();
			}
		},

		getLexiconIcon(icon, cssClass) {
			var instance = this;

			const tempElement = document.createElement('div');

			tempElement.innerHTML = instance.getLexiconIconTpl(icon, cssClass);

			return tempElement.firstChild;
		},

		getLexiconIconTpl(icon, cssClass) {
			return Liferay.Util.sub(TPL_LEXICON_ICON, icon, cssClass || '');
		},

		getOpener() {
			var openingWindow = Window._opener;

			if (!openingWindow) {
				var topUtil = Liferay.Util.getTop().Liferay.Util;

				var windowName = Liferay.Util.getWindowName();

				var dialog = topUtil.Window.getById(windowName);

				if (dialog) {
					openingWindow = dialog._opener;

					Window._opener = openingWindow;
				}
			}

			return openingWindow || window.opener || window.parent;
		},

		getTop() {
			var topWindow = Util._topWindow;

			if (!topWindow) {
				var parentWindow = window.parent;

				var parentThemeDisplay;

				while (parentWindow != window) {
					try {
						if (typeof parentWindow.location.href == 'undefined') {
							break;
						}

						parentThemeDisplay = parentWindow.themeDisplay;
					}
					catch (e) {
						break;
					}

					if (
						!parentThemeDisplay ||
						window.name === 'simulationDeviceIframe'
					) {
						break;
					}
					else if (
						!parentThemeDisplay.isStatePopUp() ||
						parentWindow == parentWindow.parent
					) {
						topWindow = parentWindow;

						break;
					}

					parentWindow = parentWindow.parent;
				}

				if (!topWindow) {
					topWindow = window;
				}

				Util._topWindow = topWindow;
			}

			return topWindow;
		},

		getURLWithSessionId(url) {
			if (!themeDisplay.isAddSessionIdToURL()) {
				return url;
			}

			// LEP-4787

			var x = url.indexOf(';');

			if (x > -1) {
				return url;
			}

			var sessionId = ';jsessionid=' + themeDisplay.getSessionId();

			x = url.indexOf('?');

			if (x > -1) {
				return url.substring(0, x) + sessionId + url.substring(x);
			}

			// In IE6, http://www.abc.com;jsessionid=XYZ does not work, but
			// http://www.abc.com/;jsessionid=XYZ does work.

			x = url.indexOf('//');

			if (x > -1) {
				var y = url.lastIndexOf('/');

				if (x + 1 == y) {
					return url + '/' + sessionId;
				}
			}

			return url + sessionId;
		},

		getWindow(id) {
			if (!id) {
				id = Util.getWindowName();
			}

			return Util.getTop().Liferay.Util.Window.getById(id);
		},

		getWindowName() {
			return window.name || Window._name || '';
		},

		/**
		 * @deprecated As of Athanasius (7.3.x), replaced by `window.innerWidth`
		 */
		getWindowWidth() {
			return window.innerWidth;
		},

		/**
		 * @deprecated As of Athanasius (7.3.x), replaced by `typeof val === 'function'`
		 */
		isFunction(val) {
			return typeof val === 'function';
		},

		listCheckboxesExcept(form, except, name, checked) {
			form = Util.getDOM(form);

			if (typeof form === 'string') {
				form = document.querySelector(form);
			}

			let selector = 'input[type=checkbox]';

			if (name) {
				selector += '[name=' + name + ']';
			}

			const checkboxes = Array.from(form.querySelectorAll(selector));

			return checkboxes
				.reduce((prev, item) => {
					const value = item.value;

					if (
						value &&
						item.name !== except &&
						item.checked === checked &&
						!item.disabled
					) {
						prev.push(value);
					}

					return prev;
				}, [])
				.join();
		},

		listCheckedExcept(form, except, name) {
			return Util.listCheckboxesExcept(form, except, name, true);
		},

		listSelect(select, delimeter) {
			select = Util.getElement(
				select instanceof RadioNodeList ? select.item(0) : select
			);

			return Array.from(select.querySelectorAll('option'))
				.reduce((prev, item) => {
					const val = item.value;

					if (val) {
						prev.push(val);
					}

					return prev;
				}, [])
				.join(delimeter || ',');
		},

		listUncheckedExcept(form, except, name) {
			return Util.listCheckboxesExcept(form, except, name, false);
		},

		openInDialog(event, config) {
			event.preventDefault();

			var currentTarget = Util.getElement(event.currentTarget);

			config = A.mix(A.merge({}, currentTarget.dataset), config);

			if (!config.uri) {
				config.uri =
					currentTarget.dataset.href ||
					currentTarget.getAttribute('href');
			}

			if (!config.title) {
				config.title = currentTarget.getAttribute('title');
			}

			Liferay.Util.openWindow(config);
		},

		openWindow(config, callback) {
			config.openingWindow = window;

			var top = Util.getTop();

			var topUtil = top.Liferay.Util;

			topUtil._openWindowProvider(config, callback);
		},

		processTab(id) {
			document.all[id].selection.text = String.fromCharCode(9);
			document.all[id].focus();
		},

		/**
		 * @deprecated As of Athanasius (7.3.x), with no direct replacement
		 */
		randomInt() {
			return Math.ceil(Math.random() * new Date().getTime());
		},

		removeEntitySelection(
			entityIdString,
			entityNameString,
			removeEntityButton,
			namespace
		) {
			const elementByEntityId = document.getElementById(
				`${namespace}${entityIdString}`
			);

			if (elementByEntityId) {
				elementByEntityId.value = 0;
			}

			const elementByEntityName = document.getElementById(
				`${namespace}${entityNameString}`
			);

			if (elementByEntityName) {
				elementByEntityName.value = '';
			}

			Liferay.Util.toggleDisabled(removeEntityButton, true);

			Liferay.fire('entitySelectionRemoved');
		},

		reorder(box, down) {
			box = Util.getElement(box);

			if (box) {
				if (box.getAttribute('selectedIndex') == -1) {
					box.setAttribute('selectedIndex', 0);
				}
				else {
					const selectedItems = Array.from(
						box.querySelectorAll('option:checked')
					);

					const items = Array.from(box.querySelectorAll('option'));

					if (down) {
						selectedItems.reverse().forEach((item) => {
							const itemIndex = items.indexOf(item);

							const lastIndex = items.length - 1;

							if (itemIndex === lastIndex) {
								box.insertBefore(item, box.firstChild);
							}
							else {
								const nextItem =
									item.nextElementSibling.nextElementSibling;

								box.insertBefore(item, nextItem);
							}
						});
					}
					else {
						selectedItems.forEach((item) => {
							const itemIndex = items.indexOf(item);

							if (itemIndex === 0) {
								box.appendChild(item);
							}
							else {
								box.insertBefore(
									item,
									item.previousElementSibling
								);
							}
						});
					}
				}
			}
		},

		rowCheckerCheckAllBox(
			ancestorTable,
			ancestorRow,
			checkboxesIds,
			checkboxAllIds,
			cssClass
		) {
			Util.checkAllBox(ancestorTable, checkboxesIds, checkboxAllIds);

			if (ancestorRow) {
				ancestorRow.toggleClass(cssClass);
			}
		},

		savePortletTitle(params) {
			params = {
				doAsUserId: 0,
				plid: 0,
				portletId: 0,
				title: '',
				url:
					themeDisplay.getPathMain() + '/portal/update_portlet_title',
				...params,
			};

			var data = {
				doAsUserId: params.doAsUserId,
				p_auth: Liferay.authToken,
				p_l_id: params.plid,
				portletId: params.portletId,
				title: params.title,
			};

			Liferay.Util.fetch(params.url, {
				body: Liferay.Util.objectToFormData(data),
				method: 'POST',
			});
		},

		selectFolder(folderData, namespace) {
			const folderDataElement = document.getElementById(
				namespace + folderData.idString
			);

			if (folderDataElement) {
				folderDataElement.value = folderData.idValue;
			}

			const folderNameElement = document.getElementById(
				namespace + folderData.nameString
			);

			if (folderNameElement) {
				folderNameElement.value = this.unescape(folderData.nameValue);
			}

			const removeFolderButton = document.getElementById(
				`${namespace}removeFolderButton`
			);

			if (removeFolderButton) {
				this.toggleDisabled(removeFolderButton, false);
			}
		},

		setCursorPosition(el, position) {
			var instance = this;

			instance.setSelectionRange(el, position, position);
		},

		setSelectionRange(el, selectionStart, selectionEnd) {
			el = Util.getDOM(el);

			if (el.jquery) {
				el = el[0];
			}

			if (el.setSelectionRange) {
				el.focus();

				el.setSelectionRange(selectionStart, selectionEnd);
			}
			else if (el.createTextRange) {
				var textRange = el.createTextRange();

				textRange.collapse(true);

				textRange.moveEnd('character', selectionEnd);
				textRange.moveEnd('character', selectionStart);

				textRange.select();
			}
		},

		showCapsLock(event, spanId) {
			const span = document.getElementById(spanId);

			if (span) {
				var keyCode = event.keyCode ? event.keyCode : event.which;

				var shiftKeyCode = keyCode === 16;

				var shiftKey = event.shiftKey ? event.shiftKey : shiftKeyCode;

				var display = 'none';

				if (
					(keyCode >= 65 && keyCode <= 90 && !shiftKey) ||
					(keyCode >= 97 && keyCode <= 122 && shiftKey)
				) {
					display = '';
				}

				span.style.display = display;
			}
		},

		/**
		 * @deprecated As of Athanasius (7.3.x), with no direct replacement
		 */
		sortByAscending(a, b) {
			a = a[1].toLowerCase();
			b = b[1].toLowerCase();

			if (a > b) {
				return 1;
			}

			if (a < b) {
				return -1;
			}

			return 0;
		},

		sub(string, data) {
			if (
				arguments.length > 2 ||
				(typeof data !== 'object' && typeof data !== 'function')
			) {
				data = Array.prototype.slice.call(arguments, 1);
			}

			return string.replace
				? string.replace(REGEX_SUB, (match, key) => {
						return data[key] === undefined ? match : data[key];
				  })
				: string;
		},

		submitCountdown: 0,

		submitForm(form) {
			form.submit();
		},

		/**
		 * @deprecated As of Athanasius (7.3.x), replaced by `parseInt()`
		 */
		toNumber(value) {
			return parseInt(value, 10) || 0;
		},

		toggleBoxes(
			checkBoxId,
			toggleBoxId,
			displayWhenUnchecked,
			toggleChildCheckboxes
		) {
			const checkBox = document.getElementById(checkBoxId);
			const toggleBox = document.getElementById(toggleBoxId);

			if (checkBox && toggleBox) {
				let checked = checkBox.checked;

				if (displayWhenUnchecked) {
					checked = !checked;
				}

				if (checked) {
					toggleBox.classList.remove('hide');
				}
				else {
					toggleBox.classList.add('hide');
				}

				checkBox.addEventListener(EVENT_CLICK, () => {
					toggleBox.classList.toggle('hide');

					if (toggleChildCheckboxes) {
						const childCheckboxes = toggleBox.querySelectorAll(
							'input[type=checkbox]'
						);

						childCheckboxes.forEach((childCheckbox) => {
							childCheckbox.checked = checkBox.checked;
						});
					}
				});
			}
		},

		toggleRadio(radioId, showBoxIds, hideBoxIds) {
			const radioButton = document.getElementById(radioId);

			if (radioButton) {
				let showBoxes;

				if (showBoxIds) {
					if (Array.isArray(showBoxIds)) {
						showBoxIds = showBoxIds.join(',#');
					}

					showBoxes = document.querySelectorAll('#' + showBoxIds);

					showBoxes.forEach((showBox) => {
						if (radioButton.checked) {
							showBox.classList.remove('hide');
						}
						else {
							showBox.classList.add('hide');
						}
					});
				}

				radioButton.addEventListener('change', () => {
					if (showBoxes) {
						showBoxes.forEach((showBox) => {
							showBox.classList.remove('hide');
						});
					}

					if (hideBoxIds) {
						if (Array.isArray(hideBoxIds)) {
							hideBoxIds = hideBoxIds.join(',#');
						}

						const hideBoxes = document.querySelectorAll(
							'#' + hideBoxIds
						);

						hideBoxes.forEach((hideBox) => {
							hideBox.classList.add('hide');
						});
					}
				});
			}
		},

		/*
		 * @deprecated As of Athanasius (7.3.x), with no direct replacement
		 */
		toggleSearchContainerButton(
			buttonId,
			searchContainerId,
			form,
			ignoreFieldName
		) {
			A.one(searchContainerId).delegate(
				EVENT_CLICK,
				() => {
					Util.toggleDisabled(
						buttonId,
						!Util.listCheckedExcept(form, ignoreFieldName)
					);
				},
				'input[type=checkbox]'
			);
		},

		toggleSelectBox(selectBoxId, value, toggleBoxId) {
			var selectBox = document.getElementById(selectBoxId);
			var toggleBox = document.getElementById(toggleBoxId);

			if (selectBox && toggleBox) {
				var dynamicValue = typeof value === 'function';

				var toggle = function () {
					var currentValue = selectBox.value;

					var visible = value == currentValue;

					if (dynamicValue) {
						visible = value(currentValue, value);
					}

					if (visible) {
						toggleBox.classList.remove('hide');
					}
					else {
						toggleBox.classList.add('hide');
					}
				};

				toggle();

				selectBox.addEventListener('change', toggle);
			}
		},
	};

	Liferay.provide(
		Util,
		'afterIframeLoaded',
		(event) => {
			var nodeInstances = A.Node._instances;

			var docEl = event.doc;

			var docUID = docEl._yuid;

			if (docUID in nodeInstances) {
				delete nodeInstances[docUID];
			}

			var iframeDocument = A.one(docEl);

			var iframeBody = iframeDocument.one('body');

			var dialog = event.dialog;

			var lfrFormContent = iframeBody.one('.lfr-form-content');

			iframeBody.addClass('dialog-iframe-popup');

			if (
				lfrFormContent &&
				iframeBody.one('.button-holder.dialog-footer')
			) {
				iframeBody.addClass('dialog-with-footer');

				var stagingAlert = iframeBody.one(
					'.portlet-body > .lfr-portlet-message-staging-alert'
				);

				if (stagingAlert) {
					stagingAlert.remove();

					lfrFormContent.prepend(stagingAlert);
				}
			}

			iframeBody.addClass(dialog.iframeConfig.bodyCssClass);

			event.win.focus();

			var detachEventHandles = function () {
				AArray.invoke(eventHandles, 'detach');

				iframeDocument.purge(true);
			};

			var eventHandles = [
				iframeBody.delegate('submit', detachEventHandles, 'form'),

				iframeBody.delegate(
					EVENT_CLICK,
					(event) => {
						dialog.set(
							'visible',
							false,
							event.currentTarget.hasClass('lfr-hide-dialog')
								? SRC_HIDE_LINK
								: null
						);

						detachEventHandles();
					},
					'.btn-cancel,.lfr-hide-dialog'
				),
			];

			Liferay.fire('modalIframeLoaded', {
				src: event.dialog.iframe.node.getAttribute('src'),
			});
		},
		['aui-base']
	);

	Liferay.provide(
		Util,
		'openDDMPortlet',
		(config, callback) => {
			var defaultValues = {
				eventName: 'selectStructure',
			};

			config = A.merge(defaultValues, config);

			var params = {
				classNameId: config.classNameId,
				classPK: config.classPK,
				doAsGroupId:
					config.doAsGroupId || themeDisplay.getScopeGroupId(),
				eventName: config.eventName,
				groupId: config.groupId,
				mvcPath: config.mvcPath || '/view.jsp',
				p_p_state: 'pop_up',
				portletResourceNamespace: config.portletResourceNamespace,
				resourceClassNameId: config.resourceClassNameId,
				scopeTitle: config.title,
				structureAvailableFields: config.structureAvailableFields,
				templateId: config.templateId,
			};

			if ('mode' in config) {
				params.mode = config.mode;
			}

			if ('navigationStartsOn' in config) {
				params.navigationStartsOn = config.navigationStartsOn;
			}

			if ('redirect' in config) {
				params.redirect = config.redirect;
			}

			if ('refererPortletName' in config) {
				params.refererPortletName = config.refererPortletName;
			}

			if ('refererWebDAVToken' in config) {
				params.refererWebDAVToken = config.refererWebDAVToken;
			}

			if ('searchRestriction' in config) {
				params.searchRestriction = config.searchRestriction;
				params.searchRestrictionClassNameId =
					config.searchRestrictionClassNameId;
				params.searchRestrictionClassPK =
					config.searchRestrictionClassPK;
			}

			if ('showAncestorScopes' in config) {
				params.showAncestorScopes = config.showAncestorScopes;
			}

			if ('showBackURL' in config) {
				params.showBackURL = config.showBackURL;
			}

			if ('showCacheableInput' in config) {
				params.showCacheableInput = config.showCacheableInput;
			}

			if ('showHeader' in config) {
				params.showHeader = config.showHeader;
			}

			if ('showManageTemplates' in config) {
				params.showManageTemplates = config.showManageTemplates;
			}

			var url = Liferay.Util.PortletURL.createRenderURL(
				config.basePortletURL,
				params
			);

			config.uri = url.toString();

			var dialogConfig = config.dialog;

			if (!dialogConfig) {
				dialogConfig = {};

				config.dialog = dialogConfig;
			}

			var eventHandles = [];

			if (callback) {
				eventHandles.push(Liferay.once(config.eventName, callback));
			}

			var detachSelectionOnHideFn = function (event) {
				Liferay.fire(config.eventName);

				if (!event.newVal) {
					new A.EventHandle(eventHandles).detach();
				}
			};

			Util.openWindow(config, (dialogWindow) => {
				eventHandles.push(
					dialogWindow.after(
						['destroy', 'visibleChange'],
						detachSelectionOnHideFn
					)
				);
			});
		},
		['aui-base']
	);

	Liferay.provide(
		Util,
		'openDocument',
		(webDavUrl, onSuccess, onError) => {
			if (A.UA.ie) {
				try {
					var executor = new A.config.win.ActiveXObject(
						'SharePoint.OpenDocuments'
					);

					executor.EditDocument(webDavUrl);

					if (Lang.isFunction(onSuccess)) {
						onSuccess();
					}
				}
				catch (e) {
					if (Lang.isFunction(onError)) {
						onError(e);
					}
				}
			}
		},
		['aui-base']
	);

	Liferay.provide(
		Util,
		'selectEntityHandler',
		(containerSelector, selectEventName, disableButton) => {
			const container = A.one(containerSelector);

			if (!container) {
				return;
			}

			const openingLiferay = Util.getOpener().Liferay;

			const selectorButtons = container
				.getDOM()
				.querySelectorAll('.selector-button');

			container.delegate(
				EVENT_CLICK,
				(event) => {
					const currentTarget = event.currentTarget.getDOM();

					if (
						currentTarget.disabled ||
						currentTarget.dataset['preventSelection']
					) {
						return;
					}

					const confirmSelection =
						currentTarget.dataset['confirmSelection'] === 'true';

					if (
						!confirmSelection ||
						confirm(
							currentTarget.dataset['confirmSelectionMessage']
						)
					) {
						if (disableButton) {
							selectorButtons.forEach((selectorButton) => {
								selectorButton.disabled = false;
							});

							currentTarget.disabled = true;
						}

						const result = Util.getAttributes(
							currentTarget,
							'data-'
						);

						openingLiferay.fire(selectEventName, result);

						const window = Util.getWindow();

						if (window) {
							window.hide();
						}
					}
				},
				'.selector-button'
			);

			openingLiferay.on('entitySelectionRemoved', () => {
				selectorButtons.forEach((selectorButton) => {
					selectorButton.disabled = false;
				});
			});
		},
		['aui-base']
	);

	Liferay.provide(
		Util,
		'portletTitleEdit',
		(options) => {
			var obj = options.obj;

			A.Event.defineOutside('mouseup');

			if (obj) {
				var title = obj.one('.portlet-title-text');

				if (title && !title.hasClass('not-editable')) {
					title.addClass('portlet-title-editable');

					title.on(EVENT_CLICK, (event) => {
						var editable = Util._getEditableInstance(title);

						var rendered = editable.get('rendered');

						if (rendered) {
							editable.fire('stopEditing');
						}

						editable.set('node', event.currentTarget);

						if (rendered) {
							editable.syncUI();
						}

						editable._startEditing(event);

						if (!rendered) {
							var defaultIconsTpl =
								A.ToolbarRenderer.prototype.TEMPLATES.icon;

							A.ToolbarRenderer.prototype.TEMPLATES.icon = Liferay.Util.getLexiconIconTpl(
								'{cssClass}'
							);

							editable._comboBox.icons.destroy();
							editable._comboBox._renderIcons();

							A.ToolbarRenderer.prototype.TEMPLATES.icon = defaultIconsTpl;
						}
					});

					title.setData('portletTitleEditOptions', options);
				}
			}
		},
		['aui-editable-deprecated', 'event-outside']
	);

	Liferay.provide(
		Util,
		'editEntity',
		(config, callback) => {
			var dialog = Util.getWindow(config.id);

			var eventName = config.eventName || config.id;

			var eventHandles = [Liferay.on(eventName, callback)];

			var detachSelectionOnHideFn = function (event) {
				if (!event.newVal) {
					new A.EventHandle(eventHandles).detach();
				}
			};

			if (dialog) {
				eventHandles.push(
					dialog.after(
						['destroy', 'visibleChange'],
						detachSelectionOnHideFn
					)
				);

				dialog.show();
			}
			else {
				var destroyDialog = function (event) {
					var dialogId = config.id;

					var dialogWindow = Util.getWindow(dialogId);

					if (
						dialogWindow &&
						Util.getPortletId(dialogId) === event.portletId
					) {
						dialogWindow.destroy();

						Liferay.detach('destroyPortlet', destroyDialog);
					}
				};

				var editURL = new Liferay.Util.PortletURL.createPortletURL(
					config.uri,
					A.merge(
						{
							eventName,
						},
						config.urlParams
					)
				);

				config.uri = editURL.toString();

				config.dialogIframe = A.merge(
					{
						bodyCssClass: 'dialog-with-footer',
					},
					config.dialogIframe || {}
				);

				Util.openWindow(config, (dialogWindow) => {
					eventHandles.push(
						dialogWindow.after(
							['destroy', 'visibleChange'],
							detachSelectionOnHideFn
						)
					);

					Liferay.on('destroyPortlet', destroyDialog);
				});
			}
		},
		['aui-base', 'liferay-util-window']
	);

	Liferay.provide(
		Util,
		'selectEntity',
		(config, callback) => {
			var dialog = Util.getWindow(config.id);

			var eventName = config.eventName || config.id;

			var eventHandles = [Liferay.on(eventName, callback)];

			var selectedData = config.selectedData;

			if (selectedData) {
				config.dialog.destroyOnHide = true;
			}

			var detachSelectionOnHideFn = function (event) {
				if (!event.newVal) {
					new A.EventHandle(eventHandles).detach();
				}
			};

			var disableSelectedAssets = function (event) {
				if (selectedData && selectedData.length) {
					var currentWindow = event.currentTarget.node.get(
						'contentWindow.document'
					);

					var selectorButtons = currentWindow.all(
						'.lfr-search-container-wrapper .selector-button'
					);

					A.some(selectorButtons, (item) => {
						var assetEntryId =
							item.attr('data-entityid') ||
							item.attr('data-entityname');

						var assetEntryIndex = selectedData.indexOf(
							assetEntryId
						);

						if (assetEntryIndex > -1) {
							item.attr('data-prevent-selection', true);
							item.attr('disabled', true);

							selectedData.splice(assetEntryIndex, 1);
						}

						return !selectedData.length;
					});
				}
			};

			if (dialog) {
				eventHandles.push(
					dialog.after(
						['destroy', 'visibleChange'],
						detachSelectionOnHideFn
					)
				);

				dialog.show();
			}
			else {
				var destroyDialog = function (event) {
					var dialogId = config.id;

					var dialogWindow = Util.getWindow(dialogId);

					if (
						dialogWindow &&
						Util.getPortletId(dialogId) === event.portletId
					) {
						dialogWindow.destroy();

						Liferay.detach('destroyPortlet', destroyDialog);
					}
				};

				Util.openWindow(config, (dialogWindow) => {
					eventHandles.push(
						dialogWindow.after(
							['destroy', 'visibleChange'],
							detachSelectionOnHideFn
						),
						dialogWindow.iframe.after(
							['load'],
							disableSelectedAssets
						)
					);

					Liferay.on('destroyPortlet', destroyDialog);
				});
			}
		},
		['aui-base', 'liferay-util-window']
	);

	Liferay.provide(
		Util,
		'toggleControls',
		(node) => {
			var docBody = A.getBody();

			node = node || docBody;

			var trigger = node.one('.toggle-controls');

			if (trigger) {
				var controlsVisible = Liferay._editControlsState === 'visible';

				var currentState = MAP_TOGGLE_STATE[controlsVisible];

				var icon = trigger.one('.lexicon-icon');

				if (icon) {
					currentState.icon = icon;
				}

				docBody.addClass(currentState.cssClass);

				Liferay.fire('toggleControls', {
					enabled: controlsVisible,
				});

				trigger.on('tap', () => {
					controlsVisible = !controlsVisible;

					var prevState = currentState;

					currentState = MAP_TOGGLE_STATE[controlsVisible];

					docBody.toggleClass(prevState.cssClass);
					docBody.toggleClass(currentState.cssClass);

					var editControlsIconClass = currentState.iconCssClass;
					var editControlsState = currentState.state;

					if (icon) {
						var newIcon = currentState.icon;

						if (!newIcon) {
							newIcon = Util.getLexiconIcon(
								editControlsIconClass
							);

							newIcon = A.one(newIcon);

							currentState.icon = newIcon;
						}

						icon.replace(newIcon);

						icon = newIcon;
					}

					Liferay._editControlsState = editControlsState;

					Liferay.Util.Session.set(
						'com.liferay.frontend.js.web_toggleControls',
						editControlsState
					);

					Liferay.fire('toggleControls', {
						enabled: controlsVisible,
						src: 'ui',
					});
				});
			}
		},
		['event-tap']
	);

	Liferay.provide(
		Util,
		'_openWindowProvider',
		(config, callback) => {
			var dialog = Window.getWindow(config);

			if (Lang.isFunction(callback)) {
				callback(dialog);
			}
		},
		['liferay-util-window']
	);

	Util.Window = Window;

	Liferay.Util = Util;

	Liferay.STATUS_CODE = {
		BAD_REQUEST: 400,
		INTERNAL_SERVER_ERROR: 500,
		OK: 200,
		SC_DUPLICATE_FILE_EXCEPTION: 490,
		SC_FILE_ANTIVIRUS_EXCEPTION: 494,
		SC_FILE_CUSTOM_EXCEPTION: 499,
		SC_FILE_EXTENSION_EXCEPTION: 491,
		SC_FILE_NAME_EXCEPTION: 492,
		SC_FILE_SIZE_EXCEPTION: 493,
		SC_UPLOAD_REQUEST_SIZE_EXCEPTION: 495,
	};

	// 0-200: Theme Developer
	// 200-400: Portlet Developer
	// 400+: Liferay

	Liferay.zIndex = {
		ALERT: 430,
		DOCK: 10,
		DOCK_PARENT: 20,
		DRAG_ITEM: 460,
		DROP_AREA: 440,
		DROP_POSITION: 450,
		MENU: 5000,
		OVERLAY: 1000,
		POPOVER: 1600,
		TOOLTIP: 10000,
		WINDOW: 1200,
	};
})(AUI(), Liferay);
