from rest_framework.serializers import ModelSerializer

from member.models import User


class UserSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = ['username', ]
