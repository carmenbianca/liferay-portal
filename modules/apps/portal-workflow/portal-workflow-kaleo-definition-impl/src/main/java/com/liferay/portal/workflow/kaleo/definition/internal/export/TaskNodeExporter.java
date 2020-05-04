/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition.internal.export;

import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.workflow.kaleo.definition.Node;
import com.liferay.portal.workflow.kaleo.definition.Task;
import com.liferay.portal.workflow.kaleo.definition.TaskForm;
import com.liferay.portal.workflow.kaleo.definition.TaskFormReference;
import com.liferay.portal.workflow.kaleo.definition.export.NodeExporter;

import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "node.type=TASK", service = NodeExporter.class
)
public class TaskNodeExporter extends BaseNodeExporter implements NodeExporter {

	@Override
	protected Element createNodeElement(Element element, String namespace) {
		return element.addElement("task", namespace);
	}

	@Override
	protected void exportAdditionalNodeElements(
		Node node, Element nodeElement) {

		Task task = (Task)node;

		exportAssignmentsElement(
			task.getAssignments(), nodeElement, "assignments");

		exportTaskForms(task.getTaskForms(), nodeElement, "task-forms");

		exportTimersElement(task, nodeElement, "task-timers", "task-timer");
	}

	protected void exportTaskForms(
		Set<TaskForm> taskForms, Element parentElement,
		String taskFormsElementName) {

		if (SetUtil.isEmpty(taskForms)) {
			return;
		}

		Element taskFormsElement = parentElement.addElement(
			taskFormsElementName);

		for (TaskForm taskForm : taskForms) {
			Element taskFormElement = taskFormsElement.addElement("task-form");

			addTextElement(taskFormElement, "name", taskForm.getName());
			addTextElement(
				taskFormElement, "description", taskForm.getDescription());

			if (Validator.isNotNull(taskForm.getFormDefinition())) {
				addTextElement(
					taskFormElement, "form-definition",
					taskForm.getFormDefinition());
			}
			else if (taskForm.getTaskFormReference() != null) {
				TaskFormReference taskFormReference =
					taskForm.getTaskFormReference();

				Element formReferenceElement = taskFormElement.addElement(
					"form-reference");

				addTextElement(
					formReferenceElement, "company-id",
					String.valueOf(taskFormReference.getCompanyId()));
				addTextElement(
					formReferenceElement, "form-id",
					String.valueOf(taskFormReference.getFormId()));
				addTextElement(
					formReferenceElement, "form-uuid",
					taskFormReference.getFormUuid());
				addTextElement(
					formReferenceElement, "group-id",
					String.valueOf(taskFormReference.getGroupId()));
			}

			addCDataElement(
				taskFormElement, "metadata", taskForm.getMetadata());
			addTextElement(
				taskFormElement, "priority",
				String.valueOf(taskForm.getPriority()));
		}
	}

}