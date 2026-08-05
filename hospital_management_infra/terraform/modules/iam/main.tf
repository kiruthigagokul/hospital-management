#######################################
# AWS Load Balancer Controller IAM Role
#######################################

data "aws_iam_policy_document" "alb_assume_role" {

  statement {

    effect = "Allow"

    principals {
      type = "Federated"

      identifiers = [
        var.oidc_provider_arn
      ]
    }

    actions = [
      "sts:AssumeRoleWithWebIdentity"
    ]

    condition {

      test = "StringEquals"

      variable = "${var.oidc_provider}:sub"

      values = [
        "system:serviceaccount:kube-system:aws-load-balancer-controller"
      ]
    }
  }
}


resource "aws_iam_role" "alb_controller" {

  name = "${var.cluster_name}-alb-controller-role"

  assume_role_policy = data.aws_iam_policy_document.alb_assume_role.json

}


resource "aws_iam_role_policy_attachment" "alb_controller" {

  role = aws_iam_role.alb_controller.name

  policy_arn = "arn:aws:iam::aws:policy/ElasticLoadBalancingFullAccess"

}