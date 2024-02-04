from time import sleep

from rest_framework.decorators import api_view, renderer_classes
from rest_framework.renderers import JSONRenderer
from rest_framework.response import Response

from member.models import User
from member.serializers import UserSerializer
from member.tasks import my_task


@api_view(('GET',))
@renderer_classes((JSONRenderer, ))
def get_users(request):
    users = User.objects.all()
    serializer = UserSerializer(users, many=True)
    return Response(data=serializer.data, status=200)


@api_view(('GET',))
@renderer_classes((JSONRenderer, ))
def run_task(request):
    my_task.delay(2, 5)
    return Response(data={}, status=200)
