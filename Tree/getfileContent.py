import os, glob

class Solution:
  def file_names(filepath):

    for filename in glob.glob(os.path.join(filepath, '*.csv')):
      newfilename = filename.split("_")

      # [a,b,2,3,c,d] --> [a,b,c,d]
      newfilename = newfilename[:2] + newfilename[4:]

      newfilename = '_'.join(newfilename)

      os.rename(filename,newfilename)

Solution.file_names('csvfiles')